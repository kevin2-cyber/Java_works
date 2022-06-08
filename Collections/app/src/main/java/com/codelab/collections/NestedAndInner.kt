package com.codelab.collections

// Nested class and Inner class is a class which is created inside another class
//  and a class which is created inside another class with keyword inner.
// In Kotlin, a nested class is by default static, so its data members and member functions
// can be accessed without creating an object of the class.
// Nested classes cannot access the data members of outer classes.

class OuterClass {
    private var name: String = "Mr. X"
    class NestedClass{
        var description: String = "code inside nested class"
        private var id: Int = 101
        fun foo(){
            // print("name is ${name}") // cannot access the outer class member
            println("Id is ${id}")
        }
    }
}

fun main(args: Array<String>) {
    // nested class must be initialized
    println(OuterClass.NestedClass().description) // accessing property

    var obj = OuterClass.NestedClass() // object creation
    obj.foo()

    println(Outer().InnerClass().description) // accessing property
    var objk = Outer().InnerClass() // object creation
    objk.foo() // access member
}

// An Inner class is a class which is created inside another class with keyword inner.
// In other words, we can say that a nested class which is marked as "inner" is called inner class.
// Inner class cannot be declared inside interfaces or non-inner nested classes.
// The advantage of inner class over nested class is that, it is able to access members
// of its outer class even if its private.

class Outer {
    private var name: String = "Mr. X"
    inner class InnerClass {
        var description: String = "code inside inner class"
        private var id: Int = 101
        fun foo() {
            println("name is ${name}") // access the private outer class member
            println("Id is ${id}")
        }
    }
}