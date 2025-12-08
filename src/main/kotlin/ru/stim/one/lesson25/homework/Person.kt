package ru.stim.one.lesson25.homework

class Person(val name: String, val age: Int) {
    var email: String = ""
    override fun toString() = "Person(name='$name', age=$age, email='$email')"
}