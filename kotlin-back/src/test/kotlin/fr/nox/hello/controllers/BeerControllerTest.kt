package fr.nox.hello.controllers

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import fr.nox.hello.db.entity.Beer
import fr.nox.hello.db.repository.BeerRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString

class BeerControllerTest {

    @Test
    fun findAllByCriteriasWithName() {

        val beerRepository: BeerRepository = mock()
        val beers = listOf(Beer("guiness", "ireland"))
        whenever(beerRepository.findByName(anyString())).thenReturn(beers)

        val result = BeerController(beerRepository).findAllByCriterias("guiness")

        assertThat(result).isEqualTo(beers)
        verify(beerRepository).findByName("guiness")
    }

    @Test
    fun findAllByCriteriasWithoutCriterias() {

        val beerRepository: BeerRepository = mock()
        val beers = listOf(Beer("guiness", "ireland"))
        whenever(beerRepository.findAll()).thenReturn(beers)

        val result = BeerController(beerRepository).findAllByCriterias(null)

        assertThat(result).isEqualTo(beers)
        verify(beerRepository).findAll()
    }
}