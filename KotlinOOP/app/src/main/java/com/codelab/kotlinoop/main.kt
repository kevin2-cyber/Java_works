package com.codelab.kotlinoop

fun main() {
    var kevin = Person("Kelvin", "Eduful")
    var john = Person()
    var johnPeterson = Person(lastName = "Peterson")
}

class Person (firstName: String = "John", lastName: String = "Doe") {

    // Initializer Block
    init {
        println("Initialized a new Person object with " +
        "firstName = $firstName and lastName = $lastName")
    }
}