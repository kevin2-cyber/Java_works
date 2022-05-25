package com.codelab.kotlin_tutorials

class Woman (private val nameO: String, private val ageO: Int): Person(name = nameO, age = ageO) {
    override fun getName(): String {
        return super.getName()
    }

    override fun getAge(): String {
        return super.getAge()
    }
}