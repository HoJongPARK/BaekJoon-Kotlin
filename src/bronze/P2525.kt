package bronze

import java.lang.Integer.parseInt
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    var st = StringTokenizer(readLine())
    var hour = parseInt(st.nextToken())
    var minute = parseInt(st.nextToken())
    var time = parseInt(readLine())

    var addToHour = time / 60
    var addToMinute = time % 60

    hour += addToHour
    minute += addToMinute

    if (minute !in minuteRange) {
        hour++
        minute -= 60
    }
    if (hour !in hourRange) {
        hour -= 24
    }

    println("$hour $minute")
}


val hourRange = IntRange(0, 23)
val minuteRange = IntRange(0, 59)