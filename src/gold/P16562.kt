package gold

import java.util.*

lateinit var friendCost: Array<Int>
private lateinit var parent: Array<Int>
fun main(args: Array<String>) {
    val input = StringTokenizer(readLine())
    val N = Integer.parseInt(input.nextToken()) //학생 수
    val M = Integer.parseInt(input.nextToken()) //친구 관계 수
    val k = Integer.parseInt(input.nextToken()) //가지고 있는 돈
    friendCost = Array(N + 1) { 0 }
    parent = Array(N + 1) { i -> i }
    val friendCostInput = StringTokenizer(readLine())
    for (i in 1..N) {
        friendCost[i] = Integer.parseInt(friendCostInput.nextToken())
    }
    for (i in 1..M) {
        val friendInfo = StringTokenizer(readLine())
        union(Integer.parseInt(friendInfo.nextToken()), Integer.parseInt(friendInfo.nextToken()))
    }
    val ret = solution(N, k) ?: "Oh no"
    print(ret)
}

fun find(a: Int): Int {
    if (a == parent[a]) return a
    parent[a] = find(parent[a])
    return parent[a]
}

fun union(a: Int, b: Int) {
    val aRoot = find(a)
    val bRoot = find(b)

    if (aRoot == bRoot) {
        return
    } else if (friendCost[aRoot] > friendCost[bRoot]) {
        parent[aRoot] = bRoot
    } else {
        parent[bRoot] = aRoot
    }
}

private fun solution(N: Int, k: Int): Int? {
    var sum = 0
    val visited = Array(N + 1) { false }
    for (i in 1..N) {
        val root = find(i)
        if (!visited[root]) {
            sum += friendCost[root]
            visited[root] = true
        }
    }
    return if (sum <= k) sum else null
}