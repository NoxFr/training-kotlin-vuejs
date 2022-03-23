package fr.nox.hello.db.entity

import fr.nox.hello.db.dto.BeerDto
import fr.nox.hello.db.dto.HopsDto
import java.util.*
import javax.persistence.*

@Entity
data class Hops(
        val name: String,
        @Id @GeneratedValue
        val uuid: UUID = UUID.randomUUID()
){
        fun toHopsDto() = HopsDto(
                name = name
        )
}