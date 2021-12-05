package study

import java.awt.Point

fun main(args: Array<String>) {
    val EMPTY: Int by lazy {
        println("Setting EMPTY!")
        100
    }

    var a =EMPTY.toChar()
    closureTest { 10 }
}

lateinit var arr: Array<Int>


fun getSize(temp: String?): Int? {
    return temp?.length
}

fun closureTest(function: () -> Int) {
    println(function())
}