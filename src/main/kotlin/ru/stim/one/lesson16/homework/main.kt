package ru.stim.one.lesson16.homework

fun main() {
    // === 1. Животные и звуки ===
    println("=== Животные ===")
    val animals = listOf(Animal(), Dog(), Cat(), Bird())
    animals.forEach { it.makeSound() }

    // === 2. Фигуры и площадь ===
    println("\n=== Площади фигур ===")
    val shapes = listOf(
        Circle(5.0),
        Square(4.0),
        Triangle(3.0, 4.0, 90.0)
    )
    shapes.forEach { shape ->
        println("Площадь: ${"%.2f".format(shape.area())}")
    }

    // === 3. Принтеры ===
    println("\n=== Принтеры ===")
    val laser = LaserPrinter()
    val inkjet = InkjetPrinter()

    val longText = "Документ для печати содержит много слов и должен быть распечатан на разных принтерах"

    laser.print(longText)
    inkjet.print(longText)

    // === 4. Корзина ===
    println("\n=== Корзина ===")
    val cart = ShoppingCart()
    cart.addToCart("A001")
    cart.addToCart("A002", 3)
    cart.addToCart(mapOf("A003" to 2, "A001" to 1))
    cart.addToCart(listOf("A004", "A004"))

    println(cart)

    // === 5. Логгер ===
    println("\n=== Логгер ===")
    val logger = Logger()

    logger.log("Пользователь вошёл")
    logger.log("WARNING", "Низкий уровень памяти")
    logger.log("ERROR", "Сервер недоступен")

    logger.log(listOf("Загрузка...", "Аутентификация", "Готово"))

    try {
        "abc".toInt()
    } catch (e: Exception) {
        logger.log(e)
    }
}