package fr.nox.hello.controllers

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import fr.nox.hello.db.dto.HopsDto
import fr.nox.hello.db.entity.Beer
import fr.nox.hello.db.entity.Hops
import fr.nox.hello.db.repository.BeerRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.ArgumentMatchers.anyString
import org.springframework.http.HttpStatus
import java.util.*
import kotlin.streams.toList

class BeerControllerTest {

    private lateinit var guinessBeer: Beer
    private lateinit var chouffeBeer: Beer
    private lateinit var guinessHops1: Hops
    private lateinit var guinessHops2: Hops
    private lateinit var guinessHopsList: List<Hops>
    private lateinit var beerRepository: BeerRepository

    @BeforeEach
    fun init(){
        guinessHops1 = Hops("hallertauer")
        guinessHops2 = Hops("tettnanger")
        guinessHopsList = listOf(guinessHops1,guinessHops2)
        guinessBeer = Beer("guiness", "ireland", guinessHopsList)
        chouffeBeer = Beer("chouffe", "belgium")
        beerRepository = mock()
    }

    @Test
    fun findAllByCriteriasWithName() {

        whenever(beerRepository.findByName(anyString())).thenReturn(guinessBeer)

        val result = BeerController(beerRepository).findAllByCriterias("guiness")

        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.body).isEqualTo(listOf(guinessBeer.toBeerDto()))
        verify(beerRepository).findByName("guiness")
    }

    @Test
    fun findAllByCriteriasWithNameNotFound() {

        whenever(beerRepository.findByName(anyString())).thenReturn(null)

        val result = BeerController(beerRepository).findAllByCriterias("guiness")

        assertThat(result.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
        verify(beerRepository).findByName("guiness")
    }

    @Test
    fun findAllByCriteriasWithoutCriterias() {

        val beers = listOf(guinessBeer)
        whenever(beerRepository.findAll()).thenReturn(beers)

        val result = BeerController(beerRepository).findAllByCriterias(null)

        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.body).isEqualTo(beers.stream().map{b -> b.toBeerDto()}.toList())
        verify(beerRepository).findAll()
    }

    @Test
    fun findByUUID() {
        val uuid = UUID.randomUUID()

        whenever(beerRepository.findById(uuid)).thenReturn(Optional.of(guinessBeer))

        val result = BeerController(beerRepository).findByUUID(uuid.toString())

        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.body).isEqualTo(guinessBeer.toBeerDto())
        verify(beerRepository).findById(uuid)
    }

    @Test
    fun findByUUIDNotFfound() {
        val uuid = UUID.randomUUID()

        whenever(beerRepository.findById(uuid)).thenReturn(Optional.empty())

        val result = BeerController(beerRepository).findByUUID(uuid.toString())

        assertThat(result.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
        verify(beerRepository).findById(uuid)
    }

    @Test
    fun add() {
        val beer = Beer("guiness", "ireland")

        BeerController(beerRepository).add(beer)

        verify(beerRepository).save(beer)

    }

    @Test
    fun delete() {
        val uuid = UUID.randomUUID()

        BeerController(beerRepository).delete(uuid.toString())

        verify(beerRepository).deleteById(uuid)
    }

    @Test
    fun findHopsByBeerName_WhenExistingBeerWithHops_ThenHopsList() {

        whenever(beerRepository.findByName(anyString())).thenReturn(guinessBeer)

        val result = BeerController(beerRepository).findHopsByBeerName("guiness")

        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.body).isEqualTo(guinessHopsList.stream().map{h -> h.toHopsDto()}.toList())
        verify(beerRepository).findByName("guiness")
    }

    @Test
    fun findHopsByBeerName_WhenExistingBeerWithoutHops_ThenEmptyHopsList() {

        whenever(beerRepository.findByName(anyString())).thenReturn(chouffeBeer)

        val result = BeerController(beerRepository).findHopsByBeerName("chouffe")

        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.body).isEqualTo(listOf<HopsDto>())
        verify(beerRepository).findByName("chouffe")
    }

    @Test
    fun findHopsByBeerName_WhenUnknownBeer_ThenNotFound() {

        whenever(beerRepository.findByName(anyString())).thenReturn(null)

        val result = BeerController(beerRepository).findHopsByBeerName("guiness")

        assertThat(result.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
        verify(beerRepository).findByName("guiness")
    }
}