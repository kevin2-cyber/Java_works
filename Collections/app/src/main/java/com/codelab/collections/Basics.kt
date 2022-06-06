package com.codelab.collections

fun main() {

    // val numbers: IntArray = intArrayOf(1,2,3,4,5,6)
    // val numbers = intArrayOf(1,2,3,4,5,6)

    val numbers = arrayOf(1,2,3,4,5,6)
    val numbersD: DoubleArray = doubleArrayOf()
    // print(numbers.contentToString())
    // for (element in numbers) {
      //  print(" ${element + 2}")
    // }
    print("initial values ${numbers.contentToString()}")
    numbers[0] = 6
    numbers[1] = 5
    numbers[4] = 2
    numbers[5] = 1

    print("\nfinal values ${numbers.contentToString()}")

}