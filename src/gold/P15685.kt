package gold

import java.util.*

val map = Array(101) { Array(101) { 0 } }

val dxDy = mapOf(
    0 to Pair(1, 0),
    1 to Pair(0, -1),
    2 to Pair(-1, 0),
    3 to Pair(0, 1)
)

fun main(args: Array<String>) {
    val N = Integer.parseInt(readLine())
    for (i in 1..N) {
        val input = StringTokenizer(readLine())
        val x = Integer.parseInt(input.nextToken())
        val y = Integer.parseInt(input.nextToken())
        val d = Integer.parseInt(input.nextToken())
        val g = Integer.parseInt(input.nextToken())
        drawDragonCurve(x, y, d, g)
    }
    println(getSquareCount())
}

fun getSquareCount(): Int {
    var count = 0
    for (i in 0..99) {
        for (j in 0..99) {
            if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1 && map[i][j + 1] == 1) {
                count++
            }
        }
    }
    return count
}

fun drawDragonCurve(x: Int, y: Int, d: Int, g: Int) {
    val directions = mutableListOf<Int>()
    directions.add(d)
    for (i in 1..g) {
        for (j in directions.size - 1 downTo 0) {
            directions.add((directions.get(j) + 1) % 4)
        }
    }
    map[y][x] = 1
    var x = x
    var y = y
    for ((i, value) in directions.withIndex()) {
        x += dxDy[value]!!.first
        y += dxDy[value]!!.second
        map[y][x] = 1
    }
}

