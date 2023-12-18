package com.vkidofdarkness.mystocks.data.remote;

import com.vkidofdarkness.mystocks.data.remote.dto.CompanyInfoDto
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query;

// интерфейс для работы с API для получения информации о статусе листинга акций
interface StockAPI {

    @GET("query?function=LISTING_STATUS")
    //@GET("securities.csv")
    suspend fun getListings(
        @Query("apikey") apikey: String = API_KEY
    ): ResponseBody

    @GET("query?function=TIME_SERIES_INTRADAY&interval=60min&datatype=csv")
    suspend fun getIntradayInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = API_KEY
    ): ResponseBody

    @GET("query?function=OVERVIEW")
    suspend fun getCompanyInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = API_KEY
    ): CompanyInfoDto

    companion object {
        const val API_KEY = "JURT9KFNBGK98R0F"
        const val BASE_URL = "https://alphavantage.co"
        //const val BASE_URL = "https://iss.moex.com/iss/"
    }
}