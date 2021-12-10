package silver

import java.awt.Point
import java.util.*


fun main() {
    val input = StringTokenizer(readLine())
    val N = input.nextToken().toInt()
    val M = input.nextToken().toInt()
    val K = input.nextToken().toInt()
    dp = Array(N) { Array(M) { 0 } }

    val OPoint = if (K != 0) Point((K - 1) % M, (K - 1) / M) else null

    println(solution(N, M, OPoint))
}

fun solution(N: Int, M: Int, OPoint: Point?): Int {
    if (null == OPoint) {
        return getAnswer(N, M, Point(M - 1, N - 1), 0, 0)
    } else {
        return getAnswer(N, M, OPoint, 0, 0) * getAnswer(N, M, Point(M - 1, N - 1), OPoint.x, OPoint.y)
    }
}

fun getAnswer(N: Int, M: Int, target: Point, x: Int, y: Int): Int {
    if (x == target.x && y == target.y) {
        return 1
    }
    for (pair in dxDy) {
        val X = x + pair.value.first
        val Y = y + pair.value.second
        if (canVisit(X, Y, N, M)) {
            if (dp[Y][X] == 0) {
                dp[y][x] += getAnswer(N, M, target, X, Y)
            } else {
                dp[y][x] += dp[Y][X]
            }
        }
    }
    return dp[y][x]
}

private val dxDy = mapOf(
    0 to Pair(1, 0),
    1 to Pair(0, 1)
)

private fun canVisit(x: Int, y: Int, N: Int, M: Int) = x >= 0 && y >= 0 && x < M && y < N
private lateinit var dp: Array<Array<Int>>

