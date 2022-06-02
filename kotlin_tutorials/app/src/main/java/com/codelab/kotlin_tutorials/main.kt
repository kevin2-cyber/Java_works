package com.codelab.kotlin_tutorials

fun main() {
    // mutable variables
    var name = "Baidoo"
    name = "Eduful"
    // immutable variables
    val myName = "Kelvin"

    // type inference finds out the type from context
    var myAge = 31

    // Integer types
    // Byte (8 bit)
    val byte: Byte = 13
    // Short (16 bit)
    val short: Short = 125
    // Int (32 bit)
    val int: Int = 123123123
    // Long (64 bit)
    val long: Long = 39_812_309_487_120_300

    // Floating Point number Types
    // Float (32 bit)
    val float: Float = 13.37F
    // Double (64 bit)
    val double: Double = 3.14159265358979323846

    // Booleans is used to represent logical values
    // It can have two possible values true and false
    var isSunny: Boolean = true
    isSunny = false

    // Characters
    val letterChar = 'A'
    val digitChar = '1'

    // Strings
    val myStr = "Hello World"
    val firstCharInStr = myStr[0]
    val lastCharInStr = myStr[myStr.length - 1]

   // print("first character is $firstCharInStr and the length of myStr is ${myStr.length}")

    // Arithmetic operators (+, -, *, /, %)
    var result = 5 + 3
    val a = 5.0
    val b = 3
    var resultDouble: Double
    resultDouble = a / b
    // print(resultDouble)

    // Comparison operators (==, !=, <, >, <=, >=)
    val isEqual = 5 == 3
    // println("isEqual is $isEqual")

    val isNotEqual = 5 != 5
    // println("isNotEqual is $isNotEqual")

//    println("is5greater3 ${5 > 3}")
//    println("is-5greater3 ${-5 > 3}")
//    println("is5LowerEqual3 ${5 <= 3}")
//    println("is5GreaterEqual3 ${5 >= 3}")

    // Assignment operators (+=, -=, *=, /=, %=)
    var myNum = 5
    myNum += 3
    myNum *= 4
    // println("myNum is $myNum")

    // Increment & Decrement operators (++, --)
    myNum++
    // println("myNum is $myNum")
    // println("myNum is ${myNum++}")
    // println("myNum is ${++myNum}")
    // println("myNum is ${--myNum}")

    val heightPerson1 = 170
    val heightPerson2 = 189

    if (heightPerson1 > heightPerson2) {
        println("use raw force")
    } else if (heightPerson1 == heightPerson2){
        println("Use your power technique 1337")
    }else {
        println("use technique")
    }

    var age = 17
    if (age >= 21) {
        println(" now you may drink in the US")
    } else if (age >= 18) {
        println("you may vote now")
    } else if (age >= 16) {
        println("you may drive now")
    } else {
        println("You are too young")
    }

}