package gold

import java.util.*

fun main() {

    val input = StringTokenizer(readLine())
    val N = input.nextToken().toInt() //노드의 개수
    val S = input.nextToken().toInt() //케니소프트의 위치
    val D = input.nextToken().toInt() //힘
    for (i in 0 until N - 1) {
        val edge = StringTokenizer(readLine())
        val x = edge.nextToken().toInt()
        val y = edge.nextToken().toInt()
        adjacentList[x].add(y)
        adjacentList[y].add(x)
    }
    dfs(Array(N + 1) { false }, S)
    val visited = Array(N + 1) { false }
    while (!leafNodes.isEmpty()) {
        toParent(leafNodes.pop(), 0, visited, D, S)
    }
    println(sum)
}

var sum: Int = 0

fun toParent(node: Int, distance: Int, visited: Array<Boolean>, D: Int, S: Int) {
    visited[node] = true
    if (node == S) {
        sum += (distance - D).coerceAtLeast(0) * 2
        return
    }
    if (!visited[parent[node]]) {
        toParent(parent[node], distance + 1, visited, D, S)
    } else {
        sum += ((distance + 1) - D).coerceAtLeast(0) * 2
    }
}

fun dfs(visited: Array<Boolean>, start: Int) {
    visited[start] = true
    parent[start] = 0
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    while (!queue.isEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val temp = queue.poll()
            var isLeap = false
            for (nextTo in adjacentList[temp]) {
                if (!visited[nextTo]) {
                    queue.add(nextTo)
                    visited[nextTo] = true
                    parent[nextTo] = temp
                    isLeap = true
                }
            }
            if (isLeap) {
                leafNodes.add(temp)
            }
        }
    }
}

private val leafNodes = Stack<Int>()
private val parent: Array<Int> = Array(100001) { 0 }
private val adjacentList: Array<MutableList<Int>> = Array(100001) { mutableListOf() }