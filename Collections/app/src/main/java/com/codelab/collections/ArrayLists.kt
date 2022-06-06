package com.codelab.collections

// ArrayLists are used to create a dynamic array. Which means the size of an
// ArrayList can be increased or decreased according to your requirement.
// The ArrayList class provides both read and write functionalities.
// The ArrayList follows the sequence of insertion order.
// An ArrayList is non synchronized and it may contain duplicate elements.

fun main() {

//    val arrayList = ArrayList<String>()
//    arrayList.add("One")
//    arrayList.add("Two")
//    println("......print ArrayList.......")
//    for (i in arrayList) {
//        println(i)
//    }

    val arrayList: ArrayList<String> = ArrayList<String>(5)
    var list: MutableList<String> = mutableListOf<String>()

    list.add("One")
    list.add("Two")

    arrayList.addAll(list)
    println("..........print ArrayList........")
    val itr = arrayList.iterator()

    while (itr.hasNext()) {
        println(itr.next())
    }
    println("size of arrayList = ${arrayList.size}")
}