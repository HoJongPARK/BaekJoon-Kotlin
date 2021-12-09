package silver

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    dp = Array(31) { 0 }
    dp[4] = 11
    dp[2] = 3
    if (N and 1 == 1) {
        println(0)
    } else {
        if (dp[N] != 0L) {
            print(dp[N])
        } else {
            println(solution(N))
        }
    }
}

fun solution(N: Int): Long {
    for (i in 4..N step 2) {
        dp[i] = dp[i - 2] * 3
        for (j in i - 4 downTo 2 step 2) {
            dp[i] += dp[j] * 2
        }
        dp[i] += 2L //마지막은 무조건 2개밖에 안나온다!
    }
    return dp[N]
}

private lateinit var dp: Array<Long>