package gold

class Car() {
    var carNumber: Int = 0
    var name: String = ""

    constructor(carNumber: Int, name: String) : this() {
        this.carNumber = carNumber
        this.name = name
    }
}

data class Bus(
    val name: String,
    val busNumber: Int
)

object constObject {
    const val ONE = 1
    const val TWO = 2
    var THREE = 3
    fun isThreeCorrect() = THREE == 3
}

fun main(args: Array<String>) {
    println(constObject.ONE)
}