package com.vkidofdarkness.mystocks.presentation.company_listings

import com.vkidofdarkness.mystocks.domain.model.CompanyListing


data class CompanyListingsState(
    val companies: List<CompanyListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
