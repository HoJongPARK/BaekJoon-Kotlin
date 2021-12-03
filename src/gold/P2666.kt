package gold

import java.util.*


fun main(args: Array<String>) {
    val N = Integer.parseInt(readLine())
    val st = StringTokenizer(readLine())
    val a = Integer.parseInt(st.nextToken())
    val b = Integer.parseInt(st.nextToken())
    val length = Integer.parseInt(readLine())
    val sequence: Array<Int> = Array(length) { 0 }
    for (i in sequence.indices) {
        sequence[i] = Integer.parseInt(readLine())
    }

    solution(a, b, sequence, 0, 0)
    println(min)
}

var min = Integer.MAX_VALUE

fun solution(a: Int, b: Int, sequence: Array<Int>, count: Int, currentIndex: Int) {
    if (currentIndex == sequence.size) {
        min = Math.min(count, min)
        return
    }

    solution(sequence[currentIndex], b, sequence, count + Math.abs(sequence[currentIndex] - a), currentIndex + 1)
    solution(a, sequence[currentIndex], sequence, count + Math.abs(sequence[currentIndex] - b), currentIndex + 1)

}


fun isCorrectHour(hour: Int) = if (hour in 0..23) true else false

