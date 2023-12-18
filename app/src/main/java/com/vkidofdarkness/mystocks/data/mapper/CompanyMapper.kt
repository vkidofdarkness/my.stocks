package com.vkidofdarkness.mystocks.data.mapper

import com.vkidofdarkness.mystocks.data.local.CompanyListingEntity
import com.vkidofdarkness.mystocks.domain.model.CompanyListing

// функции расширения, определяющие как мы воспринимаем компанию объект entity и преобразуем в model
    fun CompanyListingEntity.toCompanyListing(): CompanyListing {
        return CompanyListing(
            name = name,
            symbol = symbol,
            exchange = exchange
        )
    }

    fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
        return CompanyListingEntity(
            name = name,
            symbol = symbol,
            exchange = exchange
        )
    }
