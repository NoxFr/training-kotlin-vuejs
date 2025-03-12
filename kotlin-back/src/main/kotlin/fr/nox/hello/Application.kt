package fr.nox.hello

import fr.nox.hello.db.entity.Beer
import fr.nox.hello.db.entity.Hops
import fr.nox.hello.db.repository.BeerRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {
    @Bean
    fun init(beerRepository: BeerRepository) = CommandLineRunner {
        var hallertauer = Hops("hallertauer")
        var tettnanger = Hops("tettnanger")
        var spalt = Hops("spalt")
        var saaz = Hops("saaz")

        beerRepository.save(Beer("tripel karmeliet", "belgium", listOf(hallertauer, tettnanger)))
        beerRepository.save(Beer("guinness", "ireland", listOf(saaz)))
        beerRepository.save(Beer("la chouffe", "belgium"))
        beerRepository.save(Beer("kwak", "belgium", listOf(hallertauer, spalt)))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
