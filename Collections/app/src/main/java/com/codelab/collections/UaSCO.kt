package com.codelab.collections

// Unsafe cast operator: as
//* Sometimes it is not possible to cast a variable and it throws an exception, this is
// called an unsafe cast.
//* The unsafe cast is performed by the infix operator as.

fun main(args: Array<String>) {
    // val obj: Any? = null
    // val str: String = obj as String
    // println(str)
//    // Unsafe cast
//    val obj: Any? = "String unsafe cast"
//    val str: String? = obj as String? // Works
//    println(str)
    // Safe cast operator: as?
    //* as? provides a safe cast operation to safely cast to a type
    //* It returns a null if casting is not possible rather than throwing a
    // ClassCastException exception.
    val location: Any = "Kotlin"
    val safeString: String? = location as? String
    val safeInt: Int? = location as? Int
    println(safeString)
    println(safeInt)
}