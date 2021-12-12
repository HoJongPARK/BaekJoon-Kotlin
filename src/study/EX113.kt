package study

fun main(args: Array<String>) {

}

class CustomPair<A, B>(val first: A, val second: B) {
    override fun toString() = "$first $second"
}