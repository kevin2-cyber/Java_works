package com.codelab.kotlin_tutorials

import java.util.*


/*fun main() {
    /*
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
        // println(" now you may drink in the US")
    } else if (age >= 18) {
       // println("you may vote now")
    } else if (age >= 16) {
        // println("you may drive now")
    } else {
        // println("You are too young")
    }

    if (name == "Eduful") {
        // println("Welcome home Kelvin")
    } else {
        // println("Who are you")
    }

    var isRainy = true
    if (isRainy) {
        println("It's rainy")
    }

    var season = 3
    when(season) {
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> {
            println("Fall")
            println("Autumn")
        }
        4 -> println("Winter")
        else -> println("Invalid Season")
    }

    var month = 3
    when(month){
        in 3..5 -> println("Spring")
        in 6..8 -> println("Summer")
        in 9..11 -> println("Fall")
        12, 1, 2 -> println("Winter")
        else -> println("Invalid season")
    }

    var age = 17
    when(age){
        in 21..150 -> println("now You may drink in the US")
        in 18..20 -> println("You may vote now")
        16,17 -> println("You may drive now")
        else -> println("You are too young")
    }

    var xml: Any = 13.37F
    when(xml){
        is Int -> println("$xml is an Int")
        is Double -> println("$xml is a Double")
        is String -> println("$xml is a String")
        else -> println("$xml is none of the above")
    }

     // While loop executes a block of code repeatedly as long as a given condition is true
    var x = 1
    while (x <= 10) {
        print(x)
        x++
    }
    println("\nWhile loop is done")

    var xml = 100
    while (xml >= 0) {
        println(xml)
        xml -=2
    }
    println("While loop is done")

    var x = 1
    do {
        print(x)
        x++
    }while (x <= 10)
    println("\ndo while loop is done")

    var feltTemp = "cold"
    var roomTemp = 10
    while (feltTemp == "cold"){
        roomTemp++
        if (roomTemp >= 20) {
            feltTemp = "comfy"
            println("it's comfy now")
        }
    }

    for (num in 1..10){
        println(num)
    }

    for (i in 1 until 10){ // Same as for (i in 1.until(10)
        print("$i ")
    }

    for (i in 10 downTo 1 step 2){ // Same as for (i in 10.downTo(1).step(2))
        print("$i ")
    }

    for (i in 10.downTo(1).step(2)) {
        print("$i ")
    }

     */

    /* // Break and continue
    for (i in 1 until 20){
        print("$i ")
        if (i/2 == 5){
            break
        }
    }
    print("Done with the loop")

    for (i in 1 until 20){

        if (i/2 == 5){
            continue
        }
        print("$i ")
    }
    print("Done with the loop")

     */

/*
    // argument
    var result = addUp(5,3)
    println("result is $result")

    var average = average(5.0,6.0)
    println("the result is $average")
*/
}
 */

/*
// Method - a Method is a function within a class
// Parameter (input)
fun addUp(a: Int, b: Int): Int {
    // output
    return a + b
}

fun average(num1: Double, num2: Double): Double {
    return (num1 + num2) / 2
}

fun myFunction(){
    print("Called from myFunction")
}
 */

/*fun main() {

    val name: String = "Kelvin"
    // name = null -> Compilation ERROR
    var nullableName: String? = "Kelvin"
    nullableName = null

    var len = name.length
    var len2 = nullableName?.length
    nullableName?.let { println(it.length) }

//    // old-fashioned way
//    if (nullableName != null){
//        var len2 = nullableName.length
//    } else{
//        null
//    }



}
 */

fun main() {

    var nullableName: String? = "Kelvin"
    //nullableName = null

    var len = nullableName?.length
    println(nullableName?.length)

    // ?: Elvis operator
    val name = nullableName?: "Guest"
    println("name = $name")

    // converts a nullable type to a non-nullable type and throws a NullPointerException when it holds a null value
    println(nullableName!!.lowercase())

    // You can perform a chain safe calls
    // val wifesAge: String? = (user?.wife?.age ?: 0) as String?
}