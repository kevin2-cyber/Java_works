package com.codelab.kotlin_tutorials

open class Person(private val name: String, private val age: Int) {

    open fun getName(): String {
        return name
    }

    open fun getAge(): Int {
        return age
    }
}