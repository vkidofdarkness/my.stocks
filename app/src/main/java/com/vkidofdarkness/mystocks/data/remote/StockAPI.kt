package com.vkidofdarkness.mystocks.data.remote;

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query;

interface StockAPI {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apikey: String = API_KEY
    ): ResponseBody

    companion object {
        const val API_KEY = "JURT9KFNBGK98R0F"
        const val BASE_URL = "https://alphavantage.co"
    }
}