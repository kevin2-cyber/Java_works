package com.codelab.kotlinoop

fun main() {
    var kevin = Person("Kelvin", "Eduful")
    var john = Person()
    var johnPeterson = Person(lastName = "Peterson")

    var samsung = MobilePhone("Android", "Samsung", "Galaxy S20 Ultra")
    var iPhone = MobilePhone("iOS", "Apple", "13 Pro Max")
    var nokia = MobilePhone("Android", "Nokia", "Nokia Lumia")
}

class Person (firstName: String = "John", lastName: String = "Doe") {

    // Initializer Block
    init {
        println("Initialized a new Person object with " +
        "\nfirstName = $firstName \nand lastName = $lastName")
    }
}

class MobilePhone (osName: String, brand: String, model: String) {

    init {
        println("OS name is $osName" +
                "\nbrand is $brand" +
                "\nmodel is $model")
    }
}