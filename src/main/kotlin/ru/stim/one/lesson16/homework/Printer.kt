package ru.stim.one.lesson16.homework

// Абстрактный принтер
abstract class Printer {
    abstract fun print(text: String)
}

class LaserPrinter : Printer() {
    override fun print(text: String) {
        println("\u001b[30;47m=== Лазерная печать ===\u001b[0m")
        text.split(" ").forEach { word ->
            println("\u001b[30;47m$word\u001b[0m")
        }
    }
}

class InkjetPrinter : Printer() {
    private val colorPairs = listOf(
        "\u001b[31;40m", // Красный текст
        "\u001b[32;40m", // Зелёный
        "\u001b[34;40m", // Синий
        "\u001b[35;40m", // Пурпурный
        "\u001b[36;40m"  // Бирюзовый
    )

    override fun print(text: String) {
        println("=== Струйная печать ===")
        val words = text.split(" ")
        words.forEachIndexed { index, word ->
            val color = colorPairs[index % colorPairs.size]
            println("$color$word\u001b[0m")
        }
    }
}