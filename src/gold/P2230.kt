package gold

import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    var st = StringTokenizer(readLine())
    var N = Integer.parseInt(st.nextToken()) //정수의 개수 10만개
    var M = Integer.parseInt(st.nextToken()) //차이가 M 이상이면서 가장 작은 두 수
    var arr = ArrayList<Int>()
    for (i in 0 until N) {
        arr.add(Integer.parseInt(readLine()))
    }
    arr.sort()
    println(solution(M, arr))
}


fun solution(M: Int, arr: ArrayList<Int>): Int {
    var i = 0;
    var j = 0
    var min = Integer.MAX_VALUE
    val size = arr.size
    while (i < size && j < size) {
        val diff = arr.get(i) - arr.get(j)
        if (diff < M) {
            i++
        } else {
            min = Math.min(min, diff)
            j++
        }
    }
    while (j < size) {
        val diff = arr.get(i - 1) - arr.get(j)
        if (diff >= M) {
            min = Math.min(min, diff)
            j++
        } else {
            break
        }
    }
    return min
}

fun max(a:Int, b:Int) = if(a>b) a else b