package com.vkidofdarkness.mystocks.presentation.company_info

import com.vkidofdarkness.mystocks.domain.model.CompanyInfo
import com.vkidofdarkness.mystocks.domain.model.IntradayInfo

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)