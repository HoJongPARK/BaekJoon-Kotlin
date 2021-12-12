package study

import kotlin.reflect.KProperty

fun main() {
    var user = User()
    user.age = -50
    user.age = 100
    print(user.age)
}

class User {
    var age: Int by OnlyPositive()
}

class OnlyPositive {
    private var realValue: Int = 0
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return realValue
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        realValue = if (value > 0) value else {
            println("value : $value is negative!!")
            realValue
        }
    }

}