# Spring Boot Kotlin - VueJS Test Project

[![Build Status](https://travis-ci.org/NoxFr/training-kotlin-vuejs.svg?branch=develop)](https://travis-ci.org/NoxFr/training-kotlin-vuejs)

FullStack Kotlin (JVM) / Spring / H2 / VueJS testing app.
Feel free to fork :)

### How-to

Run the app with

```
$  cd kotlin-back
$ ./gradlew bootRun
```

### State of the work

**Back**

- HelloWorld on `/hello` path
- REST Api on `beers`

### Thoughts
Plugins adapters are lame... Developping in Kotlin JVM shows quickly how Kotlin in not Java
and how much adaptations you have to do in order to use the common Java framework
(jpa, mockito, junit, spring, etc.)

Maybe i'll give a chance to https://github.com/JetBrains/Exposed
instead of the good old JPA

Testing is also not conveniant with raw Mockito, you better use https://github.com/nhaarman/mockito-kotlin in addition
(_when_ is a restricted word in Kotlin, constructors/properties paradigm etc.)


### TODO
- Back
  - POST/PUT/DELETE
- Front

