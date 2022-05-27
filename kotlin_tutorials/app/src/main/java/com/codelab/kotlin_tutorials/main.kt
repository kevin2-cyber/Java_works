package com.codelab.kotlin_tutorials

fun main() {
    val man = Man("Kwaku",22)
    val woman = Woman("Adwoa", 21)
    val male = Male("ForeLimbs", "Hind limbs")
    val female = Female("Hand", "Leg")

    println(male.lengthOfHands())
    println(male.lengthOfLegs())
    println(male.lengthOfBoth())
    println(female.lengthOfHands())
    println(female.lengthOfLegs())
    println(female.lengthOfBoth())
    println(woman.addProp())
    println(man.addProp())
}