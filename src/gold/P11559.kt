package gold

import java.awt.Point
import java.util.*

fun main(args: Array<String>) {
    for (i in 0 until 12) {
        val input = readLine()!!
        for (j in 0 until 6) {
            map[i][j] = input[j]
        }
    }

    var count = 0
    while (checkPuyoPuyo()) {
        count++
    }
    print(count)
}

private val dxDy = mapOf(
    0 to Pair(-1, 0),
    1 to Pair(0, -1),
    2 to Pair(1, 0),
    3 to Pair(0, 1)
)

private val map = Array(12) { Array(6) { '.' } }

private const val EMPTY = '.'

fun checkPuyoPuyo(): Boolean {
    val visited = Array(12) { Array(6) { false } }
    val explode = Array(12) { Array(6) { false } }

    for (i in map.indices) {
        for (j in map[0].indices) {
            if (map[i][j] != EMPTY && !visited[i][j]) {
                bfs(j, i, visited, explode)
            }
        }
    }
    var result = false
    for (i in map.indices) {
        for (j in map[0].indices) {
            if (explode[i][j]) {
                map[i][j] = EMPTY
                result = true
            }
        }
    }
    if (result) {
        dropPuyo()
    }
    return result
}

fun bfs(x: Int, y: Int, visited: Array<Array<Boolean>>, explode: Array<Array<Boolean>>) {
    val queue: Queue<Point> = LinkedList()
    val visitQueue: Queue<Point> = LinkedList()
    visited[y][x] = true
    queue.add(Point(x, y))


    while (!queue.isEmpty()) {
        val temp = queue.poll()
        visitQueue.add(temp)
        for (move in dxDy) {
            val X = temp.x + move.value.first
            val Y = temp.y + move.value.second
            if (canVisit(X, Y, 12, 6) && !visited[Y][X] && map[Y][X] == map[temp.y][temp.x]) {
                visited[Y][X] = true
                queue.add(Point(X, Y))
            }
        }
    }
    if (visitQueue.size >= 4) {
        while (!visitQueue.isEmpty()) {
            val temp = visitQueue.poll()
            explode[temp.y][temp.x] = true
        }
    }
}

fun dropPuyo() {
    for (i in 11 downTo 1) {
        for (j in map[0].indices) {
            if (map[i][j] == EMPTY) {
                for (k in i - 1 downTo 0) {
                    if (map[k][j] != EMPTY) {
                        map[i][j] = map[k][j]
                        map[k][j] = EMPTY
                        break
                    }
                }
            }
        }
    }
}


private fun canVisit(x: Int, y: Int, N: Int, M: Int) = x >= 0 && y >= 0 && x < M && y < N


