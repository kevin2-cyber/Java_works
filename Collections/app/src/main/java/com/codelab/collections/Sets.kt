package com.codelab.collections

fun main() {

    // Sets
    val fruits = setOf("Orange", "Apple","Mango", "Grape", "Apple")
    // print(fruits.toSortedSet())

    val newFruits = fruits.toMutableList()
    newFruits.add("Water Melon")
    newFruits.add("Pear")
    // print(newFruits.elementAt(4))

    // Maps
    val daysOfTheWeek = mapOf(1 to " Monday", 2 to " Tuesday", 3 to " Wednesday")

//    for (key in daysOfTheWeek.keys) {
//        print("$key is to ${daysOfTheWeek[key]}")
//    }

    val fruitsMap = mapOf("Favorite" to Fruit("Grape", 2.5)
        , "OK" to Fruit("Apple", 1.0))

    val newDaysOfTheWeek = daysOfTheWeek.toMutableMap()
    newDaysOfTheWeek[4] = " Thursday"
    newDaysOfTheWeek[5] = " Friday"

    print(newDaysOfTheWeek.toSortedMap())

}