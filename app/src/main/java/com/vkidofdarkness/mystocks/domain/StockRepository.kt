package com.vkidofdarkness.mystocks.domain

import com.vkidofdarkness.mystocks.domain.model.CompanyListing
import com.vkidofdarkness.mystocks.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {
    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>
}