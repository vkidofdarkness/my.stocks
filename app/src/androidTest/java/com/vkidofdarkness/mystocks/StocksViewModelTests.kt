package com.vkidofdarkness.mystocks

import com.vkidofdarkness.mystocks.domain.model.CompanyListing
import com.vkidofdarkness.mystocks.domain.repository.StockRepository
import com.vkidofdarkness.mystocks.util.Resource
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.Flow

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

@RunWith(MockitoJUnitRunner::class)
class StocksViewModelTest {
    private lateinit var stockRepository: StockRepository

    @Before
    fun setup() {
        // Инициализация мок-репозитория
        stockRepository = mockk()
    }

    @Test
    fun testGetCompanyListings() {
        // Given
        val fakeCompanyListings = listOf(
            CompanyListing(name = "Stock 1", symbol = "Stock 1", exchange = "NASDAQ"),
            CompanyListing(name = "Stock 2", symbol = "Stock 2", exchange = "NASDAQ")
        )
        val fakeFlow: Flow<Resource<List<CompanyListing>>> = flowOf(Resource.Success(fakeCompanyListings))

        // Мокирование suspend функции getCompanyListings
        coEvery { stockRepository.getCompanyListings(any(), any()) } returns fakeFlow

        // When
        val result = runBlocking { stockRepository.getCompanyListings(false, "query") }

        // Then
        assertEquals(Resource.Success(fakeCompanyListings), result)
    }
}