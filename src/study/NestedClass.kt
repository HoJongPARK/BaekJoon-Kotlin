package study

fun main() {
    val outer2 = Outer2()
    outer2.extensionFunction()
    var function: (Int, Int) -> Unit = { a, b ->
        print(a + b)
        a + b
    }
    var function2: (Int) -> Unit = {
        print(it)
    }

    decorate { println("a+b = 50") }
    function2(50)
    function(5, 4)
}

fun decorate(task: () -> Unit) {
    println("작업 시작")
    task()
    println("작업 끝")
}

fun Outer2.extensionFunction() {
    print("this is extension Function")
}


class Outer {
    val a = 1

    class Nested {
        fun print() {
            print("1")
        }
    }
}

class Outer2(val a: Int = 1) {
    inner class Inner {
        fun printInfo() {
            print(a)
        }
    }
}

