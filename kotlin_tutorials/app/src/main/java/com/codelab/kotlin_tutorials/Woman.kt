package com.codelab.kotlin_tutorials

class Woman (name: String, age: Int): Person(name, age) {
    override fun getName(): String {
        return "My name is " + super.getName() + "."
    }

    override fun getAge(): String {
        return "\nI'm " + super.getAge() + " years old"
    }

    override fun addProp(): String {
        return super.addProp() + "."
    }
}