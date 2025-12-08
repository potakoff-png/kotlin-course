package ru.stim.one.lesson24.homework

// 1
fun ex1(arg: Boolean, fnc: (String) -> Unit): Int {
    return 0
}
// 2
fun Int.ex2(fnc: Int.(String) -> List<String>): List<String> {
    return fnc("")
}
// 3
fun <T, R> T.ex3(fnc: T.() -> R): R {
    return fnc()
}
// 4
fun ex4(arg: String): () -> String {
    val fnc: () -> String = { arg }
    return fnc
}
// 5
fun <U> U.ex5(): (String) -> U {
    val fnc: (String) -> U = { this }
    return fnc
}

// 6

object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}

fun String.colorize(color: String): String {
    return "$color$this${Colors.RESET}"
}

fun String.colorizeWords(fnc: (String) -> String) {
    val result = split(" ").joinToString(" ") {
        it.colorize(fnc(it))
    }
    println(result)
}

fun main() {
    val colors = listOf(Colors.RED, Colors.BLUE, Colors.GREEN, Colors.PURPLE, Colors.YELLOW, Colors.CYAN)

    val text = "Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу разным цветом. Правило подбора цвета для каждого слова нужно передавать в виде функции, которая принимает слово и возвращает это же слово но уже \"в цвете\" через функцию colorize."

    val ex1 = { word: String ->
        when {
            word[0].uppercase()[0] == word[0] -> Colors.YELLOW
            word.length < 3 -> Colors.BLUE
            word.length > 6 -> Colors.GREEN
            word.length % 2 == 0 -> Colors.RED
            else -> Colors.PURPLE
        }
    }

    var counter = 0

    val ex2 = { _: String ->
        if (counter >= colors.size) counter = 0
        colors[counter++]
    }

    var counterFunction = { counter++ }

    val ex3 = { _: String ->
        if (counter == colors.size - 1) {
            counterFunction = { counter-- }
        }
        if (counter < 0) {
            counter++
            counterFunction = { counter++ }
        }
        colors[counterFunction()]
    }

    text.colorizeWords(ex1)

    text.colorizeWords(ex2)

    counter = 0

    text.colorizeWords(ex3)
}