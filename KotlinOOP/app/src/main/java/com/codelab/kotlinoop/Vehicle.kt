package com.codelab.kotlinoop

open class Vehicle {
    // properties
    // methods
}

open class Car(val name: String, val brand: String) {
    open var range: Double = 0.0

    fun extendRange(amount: Double) {
        if(amount > 0)
            range += amount
    }

    open fun drive(distance: Double) {
        println("Drove for $distance Km")
    }
}

class ElectricCar(name: String, brand: String, batteryLife: Double)
    : Car(name, brand) {

    var chargerType = "Type1"
    override var range = batteryLife * 6

    override fun drive(distance: Double) {
        println("Drove for $distance Km on electricity")
    }

    fun drive() {
        println("Drove for $range Km on electricity")
    }
}