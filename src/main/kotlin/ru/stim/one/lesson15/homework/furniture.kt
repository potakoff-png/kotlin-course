package ru.stim.one.lesson15.homework

// Базовый абстрактный класс
abstract class Furniture(
    open val material: String,
    open val color: String,
    open val width: Double,
    open val height: Double,
    open val depth: Double
) {
    abstract fun assemble(): String
    abstract fun getUsageArea(): String
}

// Производные: Стол, Стул, Шкаф
class Table(
    override val material: String,
    override val color: String,
    override val width: Double,
    override val height: Double,
    override val depth: Double,
    val legsCount: Int
) : Furniture(material, color, width, height, depth) {
    override fun assemble(): String = "Стол собран"
    override fun getUsageArea(): String = "Обеденный стол"
}

class Chair(
    override val material: String,
    override val color: String,
    override val width: Double,
    override val height: Double,
    override val depth: Double,
    val hasBackrest: Boolean
) : Furniture(material, color, width, height, depth) {
    override fun assemble(): String = "Стул собран"
    override fun getUsageArea(): String = "Офисный стул"
}

class Wardrobe(
    override val material: String,
    override val color: String,
    override val width: Double,
    override val height: Double,
    override val depth: Double,
    val shelvesCount: Int
) : Furniture(material, color, width, height, depth) {
    override fun assemble(): String = "Шкаф собран"
    override fun getUsageArea(): String = "Гардероб"
}