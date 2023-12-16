package com.vkidofdarkness.mystocks.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CompanyListingEntity::class],
    version = 1
)
abstract class StockDB: RoomDatabase() {
    abstract val dao: StockDao
}