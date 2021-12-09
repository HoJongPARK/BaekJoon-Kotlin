package study

fun main() {
    val student = Student(100)
    val professor = Professor(30, 100)
    println(student.getSalary())
    println(professor.getSalary())
}

abstract class Person {
    abstract fun getSalary(): Int
}

class Student(val tuition: Int) : Person() {
    override fun getSalary(): Int = -tuition

}

class Professor(val classCount: Int, val wage: Int) : Person() {
    override fun getSalary() = classCount * wage
}