package gold

import java.util.*
import kotlin.collections.ArrayList

lateinit var edges: Array<ArrayList<Edge>>

fun main(args: Array<String>) {
    val input = StringTokenizer(readLine())
    val N = Integer.parseInt(input.nextToken()) //헛간의 개수
    val M = Integer.parseInt(input.nextToken()) //소들의 길 (양방향)
    edges = Array(N + 1) { ArrayList() }
    for (i in 1..M) {
        val roadInfo = StringTokenizer(readLine())
        val a = Integer.parseInt(roadInfo.nextToken())
        val b = Integer.parseInt(roadInfo.nextToken())
        val c = Integer.parseInt(roadInfo.nextToken())
        edges[a].add(Edge(b, c))
        edges[b].add(Edge(a, c))
    }
    println(solution(N, 1))
}

const val INF = 987654321

private fun solution(N: Int, start: Int): Int {
    val dist = Array(N + 1) { INF }
    val queue = PriorityQueue<Int> { o1, o2 -> dist[o1].compareTo(dist[o2]) }
    val visited = Array(N + 1) { false }
    dist[start] = 0
    queue.add(start)

    while (!queue.isEmpty()) {
        val temp = queue.poll()
        if (visited[temp]) continue
        for (edge in edges[temp]) {
            if (dist[edge.to] > dist[temp] + edge.value) {
                dist[edge.to] = dist[temp] + edge.value
                if (!visited[edge.to]) {
                    queue.add(edge.to)
                }
            }
        }
    }
    return dist[N]
}


class Edge(val to: Int, val value: Int)