package gold

enum class HoJong(number: Int, content: String) {
    HANDSOME(1, "종호는 잘생기고"), TALL(2, "키도 크고"), FASHION_LEADER(3, "패션 리더다");

    val number: Int = number
    val content: String = content
}

fun main(args: Array<String>) {
    for (item in HoJong.values()) {
        println("${item.ordinal}  ${item.name} ${item.number} ${item.content}")
    }
}