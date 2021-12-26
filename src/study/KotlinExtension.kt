package study

fun main() {
    val programmer = Programmer("Park Jong Ho", 26).apply {
        name = "Lee Dong Uk"
        age = 26
    }.also {
        print("name is ${it.name} and age is ${it.age}")
    }
}
class Programmer(var name: String, var age: Int) {
    override fun toString(): String {
        return "name : $name age $age"
    }
}

