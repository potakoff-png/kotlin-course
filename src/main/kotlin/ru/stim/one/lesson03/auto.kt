package ru.stim.one.lesson03

const val wheels = 4

class auto {

    private val vin: String = "FJJDD"
    var color: String = "black"
    var mileage: Int = 0
    lateinit var owner: String
    val utilreport: String by lazy {
        "запросы в гибдд)"
    }

}