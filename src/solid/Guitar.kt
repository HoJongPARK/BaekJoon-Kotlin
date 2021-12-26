package solid


/**
 * SRP (Single Responsibility Principle) - 단일 책임 원칙
 * 하나의 클래스는 하나의 책임만 가지고 있어야 한다.
 *
 */
class Guitar(serialNumber: String, guitarSpec: GuitarSpec) : Instrument(serialNumber = serialNumber, guitarSpec) {
}

//고유값으로 변하지 않는 제품 번호와 달리, 기타의 스펙은 언제든 변할 수 있음
//-> Extract Class 로 책임을 분리함, 스펙에 변경이 일어나면 스펙만 변경하면됨!

/*
장점
1. 책임을 분배함으로써 코드의 가독성 향상, 유지보수 용이
2. 변경의 연쇄작용이 없어짐

적용방법
1. 책임 분리 - Extract Class 를 통해 혼재된 각 책임을 각각의 개별 클래스로 분리 <-> 분리된 두 클래스간의 관계를 줄이고 복잡도를 줄이도록 설계
 유사하고 비슷한 책임을 중복해서 갖고있다면 Extract Superclass 를 사용할 수 있다.
2. 산탄총 수술 - Move Field 와 Move Method를 통해 책임을 기존의 어떤 클래스로 모으거나, 이럴만한 클래스가 없다면 새로운 클래스를 만들어 해결
 */