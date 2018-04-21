package fr.nox.hello.controllers

import fr.nox.hello.db.entity.Beer
import fr.nox.hello.db.repository.BeerRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/beers")
class BeerController(private val beerRepository: BeerRepository) {

    @GetMapping
    fun findAllByCriterias(@RequestParam("name") name: String?): Iterable<Beer> {
        if (!name.isNullOrBlank()) {
            return beerRepository.findByName(name!!)
        }
        return beerRepository.findAll()
    }

    @GetMapping("{uuid}")
    fun findByUUID(@PathVariable("uuid") uuid: String) = beerRepository.findById(UUID.fromString(uuid))

}
