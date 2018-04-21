package fr.nox.hello

import fr.nox.hello.db.entity.Beer
import fr.nox.hello.db.repository.BeerRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {
    @Bean
    fun init(repository: BeerRepository) = CommandLineRunner {
        repository.save(Beer("tripel karmeliet", "belgium"))
        repository.save(Beer("guinness", "ireland"))
        repository.save(Beer("la chouffe", "belgium"))
        repository.save(Beer("kwak", "belgium"))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
