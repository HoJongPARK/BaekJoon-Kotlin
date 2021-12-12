package study

fun main() {
    check<Int>()
}

inline fun <reified T> check() {
    val number = 0
    if (number is T) {
        print("T는 Int 타입입니다.")
    }
}