package fr.nox.hello

import fr.nox.hello.db.entity.Beer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.test.web.client.getForObject
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests(@Autowired private val restTemplate: TestRestTemplate) {

    @Test
    fun hello() {
        assertThat(restTemplate.getForObject<String>("/hello")).isEqualTo("Hello Kotlin !")
    }

    @Test
    fun beers() {
        val result = restTemplate.getForEntity<Array<Beer>>("/beers")

        assertThat(result.statusCodeValue).isEqualTo(200)
        assertThat(result.body?.asList()).hasOnlyElementsOfType(Beer::class.java)
    }
}
