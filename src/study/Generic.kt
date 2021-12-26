package study

import java.util.function.BinaryOperator

fun main() {
    val square: Int = 11.map {
        it * it
    }
    val append: Int = "1234".map {
        it.toInt() * 2
    }

    val pair: Pair<Int, String> = Pair(50, "abcd")
    val pair2: Pair<Int, String> = Pair(100, "c")
    println(pair + pair2)
    val a: Int = 5
    val b: Int = 4
    val c: Double = 5.0
    val d: Double = 13.4
    print(addToDouble<Int>(a, b))
    print(addToDouble<Double>(c, d))
    print(addToDouble(12312512L, 123123))


}

fun addInt(a: Int, b: Int): Double = a.toDouble() + b.toDouble()
fun addDouble(a: Double, b: Double) = a + b

fun <T : Number> addToDouble(a: T, b: T) = a.toDouble() + b.toDouble()

fun <T, R> T.map(mapper: (T) -> R): R {
    return mapper(this)
}

fun String.isNumber(): Int {

    return this.length
}

class Pair<A, B>(val first: A, val second: B) {
    override fun toString(): String = first.toString() + second.toString()

    operator fun plus(other: Pair<A, B>): Int {
        return 100
    }
}



