package fr.nox.hello.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloworldController {

    @GetMapping("/hello")
    fun hello() = "Hello Kotlin !"
}
