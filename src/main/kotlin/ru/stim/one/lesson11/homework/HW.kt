package ru.stim.one.lesson11.homework

// 1. Не принимает аргументов и не возвращает значения.
fun doNothing() {
    // Ничего не делаем
}

// 2. Принимает два целых числа и возвращает их сумму.
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 3. Принимает строку и ничего не возвращает.
fun processString(input: String) {
    println(input)
}

// 4. Принимает список целых чисел и возвращает среднее значение типа Double.
fun average(numbers: List<Int>): Double {
    return if (numbers.isEmpty()) 0.0 else numbers.average()
}

// 5. Принимает nullable строку и возвращает её длину в виде nullable целого числа.
// Доступна только в текущем файле.
internal fun getStringLength(str: String?): Int? {
    return str?.length
}

// 6. Не принимает аргументов и возвращает nullable вещественное число.
fun getNullableDouble(): Double? {
    return null // или какое-то значение, например 3.14
}

// 7. Принимает nullable список целых чисел, не возвращает значения.
// Доступна только в текущем файле.
internal fun processNullableList(list: List<Int>?) {
    println(list)
}

// 8. Принимает целое число и возвращает nullable строку.
fun intToString(value: Int): String? {
    return if (value >= 0) value.toString() else null
}

// 9. Не принимает аргументов и возвращает список nullable строк.
fun getNullableStringList(): List<String?> {
    return listOf("Привет", null, "Мир")
}

// 10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun checkValues(str: String?, number: Int?): Boolean? {
    return str != null && number != null && str.length > number
}

fun main() {
    // 11. multiplyByTwo
    println("multiplyByTwo(5): ${multiplyByTwo(5)}") // 10

    // 12. isEven
    println("isEven(4): ${isEven(4)}") // true
    println("isEven(7): ${isEven(7)}") // false

    // 13. printNumbersUntil
    printNumbersUntil(5) // 1 2 3 4 5
    printNumbersUntil(-1) // ничего не выведет

    // 14. findFirstNegative
    val numbers = listOf(1, 3, -5, 7, -2)
    println("findFirstNegative: ${findFirstNegative(numbers)}") // -5

    val noNegatives = listOf(1, 2, 3)
    println("findFirstNegative (no negatives): ${findFirstNegative(noNegatives)}") // null

    // 15. processList
    val stringList = listOf("Привет", "Мир", null, "Пока")
    processList(stringList) // Выведет: Привет, Мир — и остановится
}

fun multiplyByTwo(value: Int): Int {
    return value * 2
}

fun isEven(value: Int): Boolean {
    return value % 2 == 0
}

fun printNumbersUntil(n: Int) {
    if (n < 1) return
    for (i in 1..n) {
        println(i)
    }
}

fun findFirstNegative(numbers: List<Int>): Int? {
    for (number in numbers) {
        if (number < 0) {
            return number
        }
    }
    return null
}

fun processList(strings: List<String?>) {
    for (str in strings) {
        if (str == null) return
        println(str)
    }
}