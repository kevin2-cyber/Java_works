package com.codelab.kotlinoop

open class Vehicle {
    // properties
    // methods
}

open class Car(override val maxSpeed: Double,
               val name: String,
               val brand: String) : Drivable{
    open var range: Double = 0.0

    fun extendRange(amount: Double) {
        if(amount > 0)
            range += amount
    }

    open fun drive(distance: Double) {
        println("Drove for $distance Km")
    }

    // override fun drive(): String = "driving the interface drive"
    override fun drive(): String {
        return "driving the interface drive"
    }
}

class ElectricCar(maxSpeed: Double,
                  name: String,
                  brand: String,
                  batteryLife: Double)
    : Car(maxSpeed,
    name,
    brand) {

    var chargerType = "Type1"
    override var range = batteryLife * 6

    override fun drive(distance: Double) {
        println("Drove for $distance Km on electricity")
    }

    override fun drive():String {
        return "Drove for $range Km on electricity"
    }

    override fun brake() {
        super.brake()
        println("brake inside of the electric car")
    }
}