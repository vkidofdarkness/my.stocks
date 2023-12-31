package com.vkidofdarkness.mystocks.di

import android.app.Application
import androidx.room.Room
import com.vkidofdarkness.mystocks.data.local.StockDB
import com.vkidofdarkness.mystocks.data.remote.StockAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideStockAPI(): StockAPI {
        return Retrofit.Builder()
            .baseUrl(StockAPI.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideStockDB(app: Application): StockDB {
        return Room.databaseBuilder(
            app,
            StockDB::class.java,
            "stockdb.db"
        ).build()
    }
}