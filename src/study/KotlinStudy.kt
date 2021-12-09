package study

fun main() {
    val a: Int by lazy {
        print(50)
        50
    }

    val vehicle: Vehicle = Car()

    if (vehicle is Car) {
        vehicle.printInfo()
    }
    val car = vehicle as? Car
    var temp: String = ""
    temp.isOnlyNumber()
}

fun String.isOnlyNumber() {

}

open class Vehicle {

}

class Car : Vehicle() {
    fun printInfo() {
        print("i am car")
    }
}





