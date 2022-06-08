package com.codelab.collections

import java.lang.*


// Exception Handling - Handling runtime problems which occur in the program and would
// otherwise lead to program termination.
// An Exception is a runtime problem which occurs in the program and leads to program termination.
// e.g running out of memory, array out of bound, condition like divided by zero.
// To handle this type of problem during program execution the technique of
// exception handling is used.
// Exception handling is a technique which handles the runtime problems and
// maintains the flow or program execution.
// Throwable Class
// throw MyException ("this throws an exception")
// There are four different keywords used in exception handling. These are:
// try, catch,finally and throw
// try-the try block contains a set of statements which might generate an exception.
// It must be followed by either catch or finally or both,
// catch- the catch block is used to catch the exception thrown from try block.
// finally- finally block always execute whether exception is handled or not. So it is
// used to execute important code statement. (like closing buffers)
// throw- the throw keyword is used to throw an exception explicitly.
// Unchecked exception is that exception which is thrown due to mistakes in our code.
// This exception type extends the RuntimeException class.
// The Unchecked exception is checked at runtime. e.g
// ArithmeticException- thrown when we divide a number by zero.
// ArrayIndexOutOfBoundExceptions- thrown when an array has been tried to
// access with incorrect index value.
// SecurityException- thrown by the security manager to indicate a security
// violation.
// NullPointerException- thrown when invoking a method or property on a null
// object.
// A Checked exception is checked at compile time.
// This exception type extends the Throwable class. e.g
// IOException, SQLException

fun main(args: Array<String>) {
//    val str =  getNumber("10.5")
//    println(str)
//    try {
//        val a = IntArray(5)
//        a[5] = 10 / 0
//    } catch (e: ArithmeticException) {
//        println("arithmetic exception catch $e")
//    } catch (e: ArrayIndexOutOfBoundsException) {
//        println("array index out of bounds exception $e")
//    } catch (e: Exception) {
//        println("parent exception class $e")
//    }
//    println("code after try catch")

//    try {
//        val data = 10/5
//        println(data)
//    } catch (e: NullPointerException) {
//        println(e)
//    } finally {
//        println("finally block always executes")
//    }
//    println("below code...")
    validate(15)
    println("code after validation check...")
}

fun getNumber(str: String): Int {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        0
    }
}

fun validate(age: Int): Unit {
    if (age < 18)
        throw ArithmeticException("under age")
    else
        println("eligible for drive")
}
// We can use multiple catch blocks in our code.
// Multiple catch blocks are used when we are using different types of operation in
// a try block which may cause different exceptions in the try block.
// Nested try-catch block
// We can also use nested try blocks whenever required.
// The requirement of nested try catch block arises when a block of code
// generates an exception and within that block another code statement also
// generates an exception.
// Finally block
// finally block is such a block which is always executed whether exception is
// handled or not.
// So it is used to execute important code statement.
// Throw keyword
// The throw keyword is used to throw an explicit exception
// It is used to throw a custom exception.
// To throw an exception object we will use the throw-expression.
//