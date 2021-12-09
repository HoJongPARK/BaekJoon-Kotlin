package study

fun main() {
    val a = "123456789010"
    val r: String? = ""
    println(a.isLong())
    println(r.isNull())
}

fun String.isLong() = this.length > 10
fun String?.isNull() = this == null