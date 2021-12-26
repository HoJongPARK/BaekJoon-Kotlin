package solid


/*
OCP (Open-Closed Principle) 개방-폐쇄의 원칙 - 소프트웨어 요소는 확장에는 열려있으나, 변경에는 닫혀있어야한다.
요구사항의 변경이나 수정이 일어나더라도 기존 구성요소는 수정이 일어나지 않아야 하며, 기존 구성요소를 쉽게 확장해서 재사용할 수 있어야한다.

적용방법
1. 변경될 것과 변경되지 않을 것을 구분한다.
2. 이 두 모듈이 만나는 지점에 인터페이스를 지정한다.
3. 구현에 의존하기보다 정의한 인터페이스에 의존하도록 코드를 작성한다.

적용 이슈
인터페이스는 가능한 변경되어선 안된다. -> 인터페이스를 정의할 때 여러 경우의 수에 대한 고려와 예측이 필요

 */
open class Instrument(
    val serialNumber: String,
    val spec: InstrumentSpec
) {
    override fun toString(): String {
        return "serialNumber : $serialNumber\n$spec"
    }
}