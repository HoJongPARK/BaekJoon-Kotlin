package gold

import java.util.*


fun main() {
    val N = readLine()!!.toInt()
    friendList = Array(N + 1) { mutableListOf() }
    dp = Array(N + 1) { Array(2) { i -> if (i == 0) 0 else 1 } }
    visited = Array(N + 1) { false }
    //0일 떄 - > 내가 얼리어답터가 아닌 경우
    //1일 때 - > 내가 얼리어답터일 경우
    for (i in 0 until N - 1) {
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        friendList[a].add(b)
        friendList[b].add(a)
    }
    solution(1)
    println(dp[1][0].coerceAtMost(dp[1][1]))
}

fun solution(index: Int) {
    visited[index] = true
    for (to in friendList[index]) {
        if (!visited[to]) {
            solution(to)
            dp[index][0] += dp[to][1]
            dp[index][1] += Math.min(dp[to][1], dp[to][0])
        }
    }
}

private lateinit var visited: Array<Boolean>
private lateinit var dp: Array<Array<Int>>
private lateinit var friendList: Array<MutableList<Int>>