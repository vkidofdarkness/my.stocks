package com.vkidofdarkness.mystocks.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// определение сущности для использования с Room
@Entity
data class CompanyListingEntity (
    @PrimaryKey val id: Int? = null,
    val name: String,
    val symbol: String,
    val exchange: String
)