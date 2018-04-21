package fr.nox.hello.db.repository

import fr.nox.hello.db.entity.Beer
import org.springframework.data.repository.CrudRepository
import java.util.*

interface BeerRepository : CrudRepository<Beer, UUID> {
    fun findByName(name: String) : Iterable<Beer>
}