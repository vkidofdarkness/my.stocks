package com.vkidofdarkness.mystocks.data.repository

import com.vkidofdarkness.mystocks.data.local.StockDB
import com.vkidofdarkness.mystocks.data.mapper.toCompanyListing
import com.vkidofdarkness.mystocks.data.remote.StockAPI
import com.vkidofdarkness.mystocks.domain.StockRepository
import com.vkidofdarkness.mystocks.domain.model.CompanyListing
import com.vkidofdarkness.mystocks.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    val api: StockAPI,
    val db: StockDB
): StockRepository {

    private val dao = db.dao;

    // Кэширование данных
    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchCompanyListing(query)
            emit(Resource.Success(
                data = localListings.map { it.toCompanyListing() }
            ))

            // нужен ли вызов API
            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val LoadFromCache = !isDbEmpty && !fetchFromRemote
            if(LoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListings = try {
                val response = api.getListings()
                response.byteStream()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Невозможно загрузить данные."))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Невозможно загрузить данные."))
            }
        }
    }
}