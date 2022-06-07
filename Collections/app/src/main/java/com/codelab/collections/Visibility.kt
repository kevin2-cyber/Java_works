package com.codelab.collections

//Visibility Modifiers are the keywords which are used to restrict the use of classes,
// interfaces, methods and properties in Kotlin.
// These modifiers are used at multiple places such as class header or method body.
// Visibility Modifiers are categorized into four different types:
// 1. public
// 2. private
// 3. protected
// 4. internal

open class Base() {
    var a = 1 // public by default
    private var b = 2 // private to Base class
    protected open val c = 3 // visible to the Base and the Derived class
    internal val d = 4 // visible inside the same module
    protected fun e() {} // visible to the Base and the Derived class
}

class Derived : Base() {
    // a,c, d and e() of the Base class are visible
    // b is not visible
    override val c = 9 // c is protected
}

fun main(args: Array<String>) {
    val base = Base()
    // base.a and base.d are visible
    // base.b, base.c and base.e() are not visible
    val derived = Derived()
    // derived.c is not visible
}