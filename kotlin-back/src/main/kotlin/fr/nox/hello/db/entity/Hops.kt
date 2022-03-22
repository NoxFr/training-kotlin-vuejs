package fr.nox.hello.db.entity

import java.util.*
import javax.persistence.*

@Entity
data class Hops(
        val name: String,
        @Id @GeneratedValue
        val uuid: UUID = UUID.randomUUID()
)