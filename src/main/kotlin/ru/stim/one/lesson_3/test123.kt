package ru.stim.one.lesson_3

const val PI_1 = 3.14
class test123 {

    private val name: String = "John"
    var age: int = 20
    var score: Double? = null
    var speed: Double = 10.0
    lateinit var owner: String
    val wheels: int = 4

    fun example() {
        int = 10
        count = 10
    }

    var count: Int = 0
        get() {
            return if (field > 100) field else 0
        }
        set(vv) {
            if (vv > 0) field = vv
        }

}