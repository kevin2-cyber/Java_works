package com.codelab.kotlinoop

/*// import java.lang.IllegalArgumentException

// data class User(val id: Long, var name: String)

fun main() {
   /*// Creating instances of classes
    var kevin = Person("Kelvin", "Eduful", 31)
    // var john = Person()
    // var johnPeterson = Person(lastName = "Peterson")
    kevin.hobby = "to skateboard"
    kevin.age = 32
    println("${kevin.firstName} is ${kevin.age} years old")
    kevin.stateHobby()
   kevin.hobby = "play video games"
    kevin.stateHobby()

    // var samsung = MobilePhone("Android", "Samsung", "Galaxy S20 Ultra")
    // var iPhone = MobilePhone("iOS", "Apple", "13 Pro Max")
    // var nokia = MobilePhone("Android", "Nokia", "Nokia Lumia")
    */
    /*var myCar = Car()
    println("brand is : ${myCar.myBrand}")
    myCar.maxSpeed = 200
    println("MaxSpeed is : ${myCar.maxSpeed}")
    println("Model is : ${myCar.myModel}")
     */
    /*val user1 = User(1," Denis")
    // val name = user1.name
    // println(name)
    user1.name = "Michael"
    val user2 = User(1," Michael")

    println(user1 == user2)

    println("User Details: $user1")

    val updatedUser = user1.copy(name = " Kelvin Eduful")
    println(user1)
    println(updatedUser)

    println(updatedUser.component1()) // prints 1
    println(updatedUser.component2()) // prints Kelvin Eduful

    val (id,name) = updatedUser
    println("id=$id name=$name")
     */
}
 */

/*class Person (firstName: String = "Kelvin", lastName: String = "Eduful") {
    // Member variables - Properties
    var age: Int? = null
    var hobby: String = "watch Netflix"
    var firstName: String? = null

    // Initializer Block
    init {
        this.firstName = firstName
        println("Initialized a new Person object with " +
        "firstName = $firstName and lastName = $lastName")
    }

    // Member functions - Methods
    fun stateHobby(){
        println("$firstName\'s hobby is $hobby")
    }

    // Member secondary constructor
    constructor(firstName: String, lastName: String, age: Int)
        : this(firstName,lastName){
            this.age = age
        println("Initialized a new Person object with " +
                "firstName = $firstName and lastName = $lastName and age $age")
        }

}
 */

/*class MobilePhone (osName: String, brand: String, model: String) {

    init {
        println("OS name is $osName" +
                "\nbrand is $brand" +
                "\nmodel is $model")
    }
}
 */

/*class Car() {
    lateinit var owner: String

    val myBrand: String = "BMW"
    // Custom getter
    get() {
        return field.lowercase()
    }

    var maxSpeed: Int = 250
    get() = field
    set(value) {
        field = if (value > 0) value else throw IllegalArgumentException("MaxSpeed cannot be less than 0")
    }

    var myModel: String = "M5"
    private set
    init {
        this.owner = "Frank"
    }
}
 */

// The Class that inherits the features of another
// class is called the Sub class or Child or
// Derived class, and the class whose features are
// inherited is called the Super class or Parent class
// or Base class.
fun main() {
    var audiA3 = Car("A3","Audi")
    var teslaS = ElectricCar("S-Model", "Tesla", 85.0)

    teslaS.extendRange(200.0)
    teslaS.drive()
    audiA3.drive(200.0)
    teslaS.drive(200.0)
}