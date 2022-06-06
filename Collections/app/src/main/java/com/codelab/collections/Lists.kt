package com.codelab.collections

fun main() {

    val months = listOf("January", "February", "March")
    val anyTypes = listOf(1,2,3,true,false,"String")
    // print(anyTypes.size)
    // print(months[1])

//    for (month in months) {
//        println(month)
//    }
    // months.forEach { _ -> println(months)}
    val additionalMonths = months.toMutableList()
    // anyTypes.forEach{ _ -> println(anyTypes)}
    val newMonths = arrayOf("April", "May", "June")
    additionalMonths.addAll(newMonths)
    val otherMonths = arrayOf("July", "August", "September", "October", "November", "December")
    additionalMonths.addAll(otherMonths)
    // println(additionalMonths)

    val days = mutableListOf<String>("Mon", "Tue", "Wed", "Fri")
    days.add("Thu")
    days[2] = "Sunday"
    // days.removeAt(1)
    val removeList = mutableListOf<String>("Mon", "Wed")
    // days.removeAll(removeList)
    // days.removeAll(days)
    print(days)

}