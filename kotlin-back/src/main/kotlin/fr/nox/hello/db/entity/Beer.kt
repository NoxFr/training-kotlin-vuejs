package fr.nox.hello.db.entity

import java.util.*
import javax.persistence.*

@Entity
data class Beer(
        val name: String,
        val country: String,
        @Column(nullable = true)
        @OneToMany(cascade = [CascadeType.ALL])
        val hopsList: List<Hops>? = null,
        @Id @GeneratedValue
        val uuid: UUID = UUID.randomUUID()
)