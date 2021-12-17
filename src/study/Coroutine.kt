package study

import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

fun main() {
    val executerService =
        Executors.newFixedThreadPool(4); executerService.submit(ExampleRunnable())
    executerService.submit(ExampleRunnable())
/* 출력 Runnable Running
 Runnable Running
 Thread[Thread-0,5,main]
 Thread[Thread-1,5,main] */
}

class ExampleRunnable : Runnable {
    override fun run() {
        println("Runnable Running")
        println(Thread.currentThread())
    }
}

