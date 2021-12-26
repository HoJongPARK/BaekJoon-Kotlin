package study

class AAA<out T>

val a = AAA<Int>()
val b: AAA<Any> = a

class BBB<in T>

val bbbSuper = BBB<Any>()
val bbbSub: BBB<Int> = bbbSuper

fun main() {
    bbbSub.run {
        print(this.toString())
    }
    (5 + 3 - 2 * 10).run {
        if (this > 0)
            println(this)
    }

    var a: Int? = 5
    a?.let {
        print(it)
    }
    a.also {  }
}


fun String.run(block: String.() -> Unit): Unit {
    return this.block()
}

inline fun <T, R> T.run(block: T.() -> R): R {
    return this.block()
}
