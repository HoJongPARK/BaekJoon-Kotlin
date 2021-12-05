package gold

fun main(args: Array<String>) {
    val S1 = readLine()
    val S2 = readLine()
    val S3 = readLine()
    println(solution(S1!!, S2!!, S3!!))
}


fun solution(S1: String, S2: String, S3: String): Int {
    val dp = Array(S1.length) { Array(S2.length) { Array(S3.length) { 0 } } }
    var max = -1
    for (i in S1.indices) {
        for (j in S2.indices) {
            for (k in S3.indices) {
                if (S1[i] == S2[j] && S2[j] == S3[k]) {
                    if (i > 0 && j > 0 && k > 0) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1
                    } else {
                        dp[i][j][k] = 1
                    }
                } else {
                    if (k > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k - 1])
                    }
                    if (j > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k])
                    }
                    if (i > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k])
                    }
                }
                max = Math.max(max, dp[i][j][k])
            }
        }
    }
    return max
}