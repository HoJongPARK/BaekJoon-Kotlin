package study

fun main(args: Array<String>) {
    var temp: String? = null
    val size = temp?.length ?: -1
    temp?.length
    println(size)
}


fun getSize(temp: String?): Int? {
    return temp?.length
}