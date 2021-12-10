package study


//지역 변수는 항상 자신이 선언된 블록이 끝나면 소멸된다!
fun main() {
    val f: () -> Unit = returnFunc(30)
    //returnFunc의 지역변수인 num 은 returnFunc가 호출되고 나면 사라져야 하지만,
    //정상적으로 30이 출력되는 것을 확인할 수 있다. -> 클로져 함수는 자기 함수 표현식이 선언되는 순간, 자기 주변의 상황을 함께 저장한다!
    f.invoke()
}

fun returnFunc(num: Int): () -> Unit {
    return { //함수 블록
        println(num)
    }
}
