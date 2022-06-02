package com.codelab.kotlin_tutorials

fun main() {
    // mutable variables
    var name = "Baidoo"
    name = "Eduful"
    // immutable variables
    val myName = "Kelvin"

    // type inference
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
    var firstCharInStr = myStr[0]
    var lastCharInStr = myStr[myStr.length - 1]

    print("first character is " + firstCharInStr)
    print(" last character is " + lastCharInStr)

}