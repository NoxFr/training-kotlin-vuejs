package fr.nox.hello.db.entity

import fr.nox.hello.db.dto.BeerDto
import java.util.*
import javax.persistence.*

@Entity
data class Beer(
        val name: String,
        val country: String,
        @Column(nullable = true)
        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val hopsList: List<Hops>? = null,
        @Id @GeneratedValue
        val uuid: UUID = UUID.randomUUID()
)
{
        fun toBeerDto() = BeerDto (
                name = name,
                country = country
        )
}