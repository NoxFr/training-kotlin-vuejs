package fr.nox.hello.controllers

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import fr.nox.hello.db.entity.Beer
import fr.nox.hello.db.repository.BeerRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.springframework.http.HttpStatus
import java.util.*

class BeerControllerTest {

    @Test
    fun findAllByCriteriasWithName() {

        val beerRepository: BeerRepository = mock()
        val beer = Beer("guiness", "ireland")
        whenever(beerRepository.findByName(anyString())).thenReturn(beer)

        val result = BeerController(beerRepository).findAllByCriterias("guiness")

        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.body).isEqualTo(listOf(beer))
        verify(beerRepository).findByName("guiness")
    }

    @Test
    fun findAllByCriteriasWithNameNotFound() {

        val beerRepository: BeerRepository = mock()
        whenever(beerRepository.findByName(anyString())).thenReturn(null)

        val result = BeerController(beerRepository).findAllByCriterias("guiness")

        assertThat(result.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
        verify(beerRepository).findByName("guiness")
    }

    @Test
    fun findAllByCriteriasWithoutCriterias() {

        val beerRepository: BeerRepository = mock()
        val beers = listOf(Beer("guiness", "ireland"))
        whenever(beerRepository.findAll()).thenReturn(beers)

        val result = BeerController(beerRepository).findAllByCriterias(null)

        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.body).isEqualTo(beers)
        verify(beerRepository).findAll()
    }

    @Test
    fun findByUUID() {
        val uuid = UUID.randomUUID()

        val beerRepository: BeerRepository = mock()
        val beer = Beer("guiness", "ireland")
        whenever(beerRepository.findById(uuid)).thenReturn(Optional.of(beer))

        val result = BeerController(beerRepository).findByUUID(uuid.toString())

        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.body).isEqualTo(beer)
        verify(beerRepository).findById(uuid)
    }

    @Test
    fun findByUUIDNotFfound() {
        val uuid = UUID.randomUUID()

        val beerRepository: BeerRepository = mock()
        whenever(beerRepository.findById(uuid)).thenReturn(Optional.empty())

        val result = BeerController(beerRepository).findByUUID(uuid.toString())

        assertThat(result.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
        verify(beerRepository).findById(uuid)
    }

    @Test
    fun add() {
        val beer = Beer("guiness", "ireland")
        val beerRepository: BeerRepository = mock()

        BeerController(beerRepository).add(beer)

        verify(beerRepository).save(beer)

    }

    @Test
    fun delete() {
        val uuid = UUID.randomUUID()
        val beerRepository: BeerRepository = mock()

        BeerController(beerRepository).delete(uuid.toString())

        verify(beerRepository).deleteById(uuid)
    }

}