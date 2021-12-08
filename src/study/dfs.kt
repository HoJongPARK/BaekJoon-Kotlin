package study

import java.util.*
import kotlin.collections.ArrayList


fun main() {
    //13개의 정점에 대한 인접 리스트
    val adjacentList: Array<ArrayList<Int>> = Array(14) { ArrayList() }
    initAdjacentList3(adjacentList)
    dfs(1, Array(14) { false }, adjacentList, Array(14) { false })
}

//재귀 호출을 이용한 dfs 의 구현
fun dfs(to: Int, visited: Array<Boolean>, adjacentList: Array<ArrayList<Int>>, visitStack: Array<Boolean>) {
    visited[to] = true // -> 현재 정점에 대한 방문 처리
    visitStack[to] = true // -> 현재 탐색 루트에서 해당 정점을 방문 처리 만약 이 정점에서 시작하는 탐색이 모두 끝나면 다시 false 로 변경
    println("$to ${if (adjacentList[to].isEmpty()) "나는 리프노드입니다!" else ""}") //-> 탐색 순서를 출력
    //만약 다음 노드를 방문하지 않았다면, 다음 노드 방문
    for (goTo in adjacentList[to]) {
        if (!visited[goTo]) {
            dfs(goTo, visited, adjacentList, visitStack)
        } else if (visitStack[goTo]) {
            println("$goTo 를 향한 Cycle 이 발생함!")
        }
    }
    visitStack[to] = false // -> 현재 정점에서 시작한 탐색이 모두 끝났으므로, 방문 여부를 다시 false 로 변경
}

fun stackDfs(start: Int, adjacentList: Array<ArrayList<Int>>) {
    val visited = Array(14) { false }
    visited[start] = true;
    val stack = Stack<Int>()
    stack.add(start)

    while (!stack.isEmpty()) {
        val to = stack.pop()
        println("$to ${if (adjacentList[to].isEmpty()) "나는 리프노드입니다!" else ""}") //-> 탐색 순서를 출력
        for (goTo in adjacentList[to]) {
            if (!visited[goTo]) {
                visited[goTo] = true
                stack.add(goTo)
            }
        }
    }
}

fun initAdjacentList(adjacentList: Array<ArrayList<Int>>) {
    adjacentList[1].add(2)
    adjacentList[1].add(5)
    adjacentList[1].add(9)
    adjacentList[2].add(3)
    adjacentList[2].add(4)
    adjacentList[5].add(6)
    adjacentList[5].add(7)
    adjacentList[7].add(8)
    adjacentList[9].add(10)
    adjacentList[9].add(13)
    adjacentList[10].add(11)
    adjacentList[10].add(12)
}

fun initAdjacentList2(adjacentList: Array<ArrayList<Int>>) {
    adjacentList[1].add(2)
    adjacentList[1].add(5)
    adjacentList[2].add(3)
    adjacentList[5].add(6)
    adjacentList[2].add(6)
    adjacentList[3].add(4)
    adjacentList[6].add(4)
    adjacentList[4].add(7)
    adjacentList[7].add(6)
}

fun initAdjacentList3(adjacentList: Array<ArrayList<Int>>) {
    adjacentList[1].add(2)
    adjacentList[1].add(3)
    adjacentList[1].add(4)
    adjacentList[2].add(5)
    adjacentList[2].add(6)
    adjacentList[3].add(7)
    adjacentList[7].add(9)
    adjacentList[9].add(8)
    adjacentList[8].add(7)
    adjacentList[4].add(11)
    adjacentList[11].add(12)
    adjacentList[12].add(10)
    adjacentList[10].add(4)

}

