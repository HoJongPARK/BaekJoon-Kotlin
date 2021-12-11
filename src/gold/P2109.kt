package gold

import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    lecture = Array(10001) { LinkedList() }
    for (i in 0 until n) {
        val input = StringTokenizer(readLine())
        val p = input.nextToken().toInt()
        val d = input.nextToken().toInt()
        lecture[d].add(p)
    }
    println(solution())
}

fun solution(): Int {
    val lectures = PriorityQueue<Int>()

    //현재 일 수 만큼만 넣으면된다.. 작은건 빼고 큰것만 남기게..
    for (i in 1..10000) {
        while (!lecture[i].isEmpty()) {
            val price = lecture[i].poll()
            if (lectures.size < i) {
                lectures.add(price)
            } else if (lectures.peek() < price) {
                lectures.poll()
                lectures.add(price)
            }
        }
    }
    var sum = 0
    while (!lectures.isEmpty()) {
        sum += lectures.poll()
    }
    return sum
}

private lateinit var lecture: Array<Queue<Int>>