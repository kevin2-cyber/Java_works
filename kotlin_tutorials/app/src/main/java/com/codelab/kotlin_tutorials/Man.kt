package com.codelab.kotlin_tutorials

class Man(name: String, age: Int) : Person(
    name, age
) {
   override fun getName(): String {
        return "My name is " + getName()
    }

    override fun getAge(): Int {
        return getAge()
    }
}