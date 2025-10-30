package ru.stim.one.lesson16.homework

// Абстрактный базовый класс
abstract class Shape {
    abstract fun area(): Double
}

class Circle(private val radius: Double) : Shape() {
    override fun area(): Double = Math.PI * radius * radius
}

class Square(private val side: Double) : Shape() {
    override fun area(): Double = side * side
}

class Triangle(
    private val a: Double,
    private val b: Double,
    private val angleDegrees: Double
) : Shape() {
    override fun area(): Double {
        val angleRad = Math.toRadians(angleDegrees)
        return 0.5 * a * b * kotlin.math.sin(angleRad)
    }
}