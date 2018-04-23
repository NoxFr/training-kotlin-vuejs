package fr.nox.hello

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MyWebMvcConfigurer : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry?) {
        registry!!.addMapping("/beers").allowedOrigins("http://localhost:8080")
    }
}