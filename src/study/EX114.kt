package study

fun main() {
    val A = Rectangle(5, 10)
    val B = Rectangle(15, 20)
    val C = A + B


    print(C.toString())
}

interface Plusable<T> {
    operator fun plus(other: T): T
}

interface Minusable<T> {
    operator fun minus(other: T): T
}

fun <T> plusOrMinus(A: T, B: T) where T : Plusable<T>, T : Minusable<T> {
    println(A + B)
    println(A - B)
}

class Rectangle(val width: Int, val height: Int) : Plusable<Rectangle> {
    override fun plus(other: Rectangle): Rectangle = Rectangle(width + other.width, height + other.height)

    override fun toString() = "width : $width height : $height"
}

fun plusAll(vararg number: Int): Int {
    var sum = 0
    for (i in number) {
        sum += i
    }
    return sum
}