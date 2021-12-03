package gold

import java.util.*

lateinit var arr: IntArray

fun main(args: Array<String>) {
    val st = StringTokenizer(readLine())
    val T = Integer.parseInt(st.nextToken()) //자두가 떨어지는 시간
    val W = Integer.parseInt(st.nextToken()) //움직일 수 있는 횟수
    arr = IntArray(T)
    for (i in arr.indices) {
        arr[i] = Integer.parseInt(readLine())
    }
    println(solution(T, W, arr))
}


fun solution(T: Int, W: Int, arr: IntArray): Int {
    var dp = Array(T) { Array(W + 1) { Array(3) { 0 } } }

    if (arr[0] == 1) {
        dp[0][0][1] = 1
        dp[0][1][2] = 1
    } else {
        dp[0][1][2] = 1
    }

    for (i in 1 until T) {
        val a = arr[i]
        dp[i][0][1] = dp[i - 1][0][1]
        dp[i][0][2] = dp[i - 1][0][2]
        dp[i][0][a]++
        for (j in 1..W) {
            if (a == 1) {
                dp[i][j][1] = Math.max(dp[i - 1][j][1] + 1, dp[i - 1][j - 1][2] + 1)
                dp[i][j][2] = dp[i - 1][j][2]
            } else {
                dp[i][j][2] = Math.max(dp[i - 1][j][2] + 1, dp[i - 1][j - 1][1] + 1)
                dp[i][j][1] = dp[i - 1][j][1]
            }
        }
    }

    var max = Integer.MIN_VALUE
    for (i in dp[0].indices) {
        max = Math.max(max, dp[T - 1][i][1])
        max = Math.max(max, dp[T - 1][i][2])
    }
    return max
}


