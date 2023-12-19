package com.vkidofdarkness.mystocks.di

import com.vkidofdarkness.mystocks.data.csv.CSVParser
import com.vkidofdarkness.mystocks.data.csv.CompanyListingsParser
import com.vkidofdarkness.mystocks.data.csv.IntradayInfoParser
import com.vkidofdarkness.mystocks.data.repository.StockRepositoryImpl
import com.vkidofdarkness.mystocks.domain.repository.StockRepository
import com.vkidofdarkness.mystocks.domain.model.CompanyListing
import com.vkidofdarkness.mystocks.domain.model.IntradayInfo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}