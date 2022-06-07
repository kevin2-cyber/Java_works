package com.codelab.collections

//-Lambda (Expression) is a function which has no name.
//-Lambda expressions and anonymous functions are 'function literals',i.e.functions
// that are not declared, but passed immediately as an expression.
//-Lambda is defined with curly braces {} which takes variables as a parameter (if any)
// and a body of a function.
//-The body of a function is written after the variable (if any) followed by -> operator.
//-Syntax: {variable(s) -> body_of_lambda}
fun main() {

    addNumber(2,5)

    // lambda
    val sum: (Int,Int) -> Int = {first: Int, second: Int -> first + second}
    print(sum(3,5))

    // shorter form of lambda
    val add = {a: Int, b: Int -> println(a + b)}
    add(2,3)

}

fun addNumber(a: Int, b: Int) {
    val add = a + b
    println(add)
}




