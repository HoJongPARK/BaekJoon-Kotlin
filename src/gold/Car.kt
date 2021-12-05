package gold

import java.lang.IllegalStateException

class Car() {
    var carNumber: Int? = 0
    var name: String = ""

    constructor(carNumber: Int?, name: String) : this() {
        this.carNumber = carNumber
        this.name = name
    }
}

fun main(args: Array<String>) {
    val car = Car(null, "Hi")
    car.carNumber?.let { value ->
        print("car Number is $value") //carNumber가 null 이기 때문에 실행되지 않는다.
    }
    car.carNumber = 1
    car.carNumber?.let { value ->
        print("car Number is $value") //carNumber가 1이기 때문에 해당 구문이 실행된다.
    }
}

