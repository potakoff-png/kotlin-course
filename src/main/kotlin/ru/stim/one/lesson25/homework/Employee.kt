package ru.stim.one.lesson25.homework

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
    override fun toString() = "Employee(name='$name', age=$age, position='$position', email='$email', department='$department')"
}