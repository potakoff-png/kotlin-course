package ru.stim.one.lesson15.homework

// Базовый абстрактный класс
abstract class GeometricShape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
}

// Производные: Многоугольник и Круг
abstract class Polygon : GeometricShape()

class Circle(private val radius: Double) : GeometricShape() {
    override fun area(): Double = Math.PI * radius * radius
    override fun perimeter(): Double = 2 * Math.PI * radius
}

// Дополнительное разветвление для Многоугольник
class Triangle(private val a: Double, private val b: Double, private val c: Double) : Polygon() {
    override fun area(): Double {
        val s = perimeter() / 2
        return kotlin.math.sqrt(s * (s - a) * (s - b) * (s - c))
    }

    override fun perimeter(): Double = a + b + c
}

class Quadrilateral(private val side1: Double, private val side2: Double, private val side3: Double, private val side4: Double) : Polygon() {
    override fun area(): Double = 0.0 // Упрощённо — зависит от типа
    override fun perimeter(): Double = side1 + side2 + side3 + side4
}