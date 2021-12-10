package silver


fun main(args: Array<String>) {
    val input = readLine()!!
    val dp = Array(input.length + 2) { 0 }

    dp[0] = 1
    var a: Int = 0

    if (input.length > 1) {
        a = (input[0] - '0') * 10 + (input[1] - '0')
    }
    if (a in 11..19 || a in 21..26) {
        dp[1] = 2
    } else {
        dp[1] = 1
    }

    if (input[0] == '0' || (input.length > 1 && a !in 10..26 && input[1] == '0')) {
        print(0)
        return
    }
    for (i in 2 until input.length) {
        val temp: Int = (input[i - 1] - '0') * 10 + (input[i] - '0')
        if (input[i] == '0') {
            if (temp in 10..20) {
                dp[i] = dp[i - 2]
            } else {
                print(0)
                return
            }
        } else {
            if (temp in 11..26) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD
            } else {
                dp[i] = dp[i - 1]
            }
        }
    }
    println(dp[input.length - 1])
}

private const val MOD = 1_000_000