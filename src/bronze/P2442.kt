import java.lang.Integer.parseInt
import java.lang.StringBuilder
import java.util.*

fun main(args:Array<String>) {
    val N = parseInt(readLine())
    printStar(N)
}


fun printStar(N:Int) {
    var sb = StringBuilder()
    val max = -1+N*2
    for(index in 1..max step 2){
        for(i in 1..(max-index)/2){
            sb.append(" ")
        }
        for(i in 1..index){
            sb.append("*")
        }
        sb.append("\n")
    }
    print(sb)
}