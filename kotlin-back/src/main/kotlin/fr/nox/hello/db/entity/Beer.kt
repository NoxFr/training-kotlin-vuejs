package fr.nox.hello.db.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Beer(
        val name: String,
        val country: String,
        @Id @GeneratedValue
        val uuid: UUID = UUID.randomUUID()
)