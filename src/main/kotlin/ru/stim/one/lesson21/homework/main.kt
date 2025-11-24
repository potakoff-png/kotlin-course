package ru.stim.one.lesson21.homework

fun analyzeDataType(value: Any) {
    when (value) {
        is String -> println("Это строка: $value")
        is Number -> println("Это число: $value")
        is List<*> -> println("Это список, количество элементов: ${value.size}")
        is Map<*, *> -> println("Это словарь, количество пар: ${value.size}")
        else -> println("Неизвестный тип данных")
    }
}

fun safeCastToList(value: Any): Int {
    val list = value as? List<*>
    return list?.size ?: -1
}

fun getStringLengthOrZero(value: Any?): Int {
    return (value as? String)?.length ?: 0
}

fun Any.toSquare(): Double {
    val number = (this as? Number)?.toDouble()
        ?: (this as String).toDouble()
    return number * number
}

fun sumIntOrDoubleValues(list: List<Any>): Double {
    return list.sumOf { (it as? Int)?.toDouble() ?: (it as? Double) ?: 0.0 }
}

fun tryCastToListAndPrint(arg: Any) {
    val result = (arg as? List<*>)?.map { (it as? String) ?: "Элемент не является строкой" }
        ?: "Не удалось преобразовать аргумент в список"
    println(result)
}

fun main() {
    println("=== Задача 1: analyzeDataType ===")
    analyzeDataType("Hello")
    analyzeDataType(42)
    analyzeDataType(3.14)
    analyzeDataType(listOf(1, 2, 3))
    analyzeDataType(mapOf("a" to 1, "b" to 2))
    analyzeDataType(true)

    println("\n=== Задача 2: safeCastToList ===")
    println("Размер списка: ${safeCastToList(listOf("a", "b"))}") // 2
    println("Размер не списка: ${safeCastToList("not a list")}") // -1

    println("\n=== Задача 3: getStringLengthOrZero ===")
    println("Длина 'Kotlin': ${getStringLengthOrZero("Kotlin")}") // 6
    println("Длина null: ${getStringLengthOrZero(null)}") // 0
    println("Длина 123: ${getStringLengthOrZero(123)}") // 0

    println("\n=== Задача 4: toSquare() ===")
    println("4.toSquare() = ${4.toSquare()}") // 16.0
    println("4.2.toSquare() = ${4.2.toSquare()}") // 17.64
    println("\"3\".toSquare() = ${"3".toSquare()}") // 9.0

    println("\n=== Задача 5: sumIntOrDoubleValues ===")
    val mixedList = listOf(1, "hello", 2.5, true, 3, 4.0, listOf(1))
    println("Сумма чисел: ${sumIntOrDoubleValues(mixedList)}") // 1 + 2.5 + 3 + 4.0 = 10.5

    println("\n=== Задача 6: tryCastToListAndPrint ===")
    tryCastToListAndPrint(listOf("a", "b", 123, "c", 4.5))
    tryCastToListAndPrint("not a list")
}