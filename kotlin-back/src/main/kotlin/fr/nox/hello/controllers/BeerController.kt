package fr.nox.hello.controllers

import fr.nox.hello.db.entity.Beer
import fr.nox.hello.db.entity.Hops
import fr.nox.hello.db.repository.BeerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping( "/beers")
class BeerController(private val beerRepository: BeerRepository) {

    @GetMapping
    fun findAllByCriterias(@RequestParam("name") name: String?): ResponseEntity<Iterable<Beer>> {
        if (!name.isNullOrBlank()) {
            val beer = beerRepository.findByName(name!!)
            if (beer != null) {
                return ResponseEntity(listOf(beer), HttpStatus.OK)
            }
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(beerRepository.findAll(), HttpStatus.OK)
    }

    @GetMapping("hops")
    fun findHopsByBeerName(@RequestParam("beerName") beerName: String): ResponseEntity<Iterable<Hops>> {
        var hops = listOf<Hops>();
        val beer = beerRepository.findByName(beerName)
        if(beer == null){
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }else if(beer.hopsList != null){
            hops = beer.hopsList;
        }
        return ResponseEntity(hops, HttpStatus.OK)
    }

    @GetMapping("{uuid}")
    fun findByUUID(@PathVariable("uuid") uuid: String) : ResponseEntity<Beer> {
        val beer = beerRepository.findById(UUID.fromString(uuid))
        if (beer.isPresent) {
            return ResponseEntity(beer.get(), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping
    fun add(@RequestBody beer: Beer) = beerRepository.save(beer)

    @DeleteMapping("{uuid}")
    fun delete(@PathVariable("uuid") uuid: String) = beerRepository.deleteById(UUID.fromString(uuid))
}
