package ru.stim.one.lesson20.homework

fun <T : Number> Array<T>.firstAndLast(): Pair<T?, T?> {
    if (this.isEmpty()) return null to null
    return this.first() to this.last()
}

fun <T : Comparable<T>> MutableList<T>.sortAndFreeze(ascending: Boolean): List<T> {
    if (ascending) {
        this.sort()
    } else {
        this.sortDescending()
    }
    return this.toList() // возвращает неизменяемый список
}

fun <K, V> Map<K, List<V>>?.getValueByIndex(index: Int): Map<String, V?>? {
    if (this == null) return null
    return this.map { (key, list) ->
        val value = if (index in list.indices) list[index] else null
        key.toString() to value
    }.toMap()
}

fun Number.within(other: Number, deviation: Number): Boolean {
    val diff = this.toDouble() - other.toDouble()
    return kotlin.math.abs(diff) <= deviation.toDouble()
}

fun String.encrypt(base: Int): String {
    return this.map { char -> (char.code + base).toChar() }.joinToString("")
}

fun String.decrypt(base: Int): String {
    return this.map { char -> (char.code - base).toChar() }.joinToString("")
}

fun String.printAsTwitterGame(usernames: List<String>) {
    val upperChars = this.uppercase().toList()
    if (upperChars.size != usernames.size) {
        println("Количество букв и имён не совпадает. Ожидается: ${upperChars.size}, получено: ${usernames.size}")
        return
    }

    upperChars.forEachIndexed { index, char ->
        println("${usernames[index]}:\n$char\n")
    }
}

fun main() {
    // === 1. firstAndLast() ===
    val numbers = arrayOf(10, 20, 30, 40)
    println("Первый и последний: ${numbers.firstAndLast()}") // (10, 40)

    val emptyArray = emptyArray<Int>()
    println("Пустой массив: ${emptyArray.firstAndLast()}") // (null, null)

    // === 2. sortAndFreeze() ===
    val mutableList = mutableListOf("banana", "apple", "cherry")
    val sortedList = mutableList.sortAndFreeze(ascending = true)
    println("Отсортировано по возрастанию: $sortedList")
    println("Исходный список изменён: $mutableList")

    val numbersList = mutableListOf(5, 1, 9, 3)
    val sortedNumbers = numbersList.sortAndFreeze(ascending = false)
    println("По убыванию: $sortedNumbers")

    // === 3. getValueByIndex() ===
    val data: Map<String, List<Int>>? = mapOf(
        "A" to listOf(10, 20),
        "B" to listOf(30),
        "C" to listOf(40, 50, 60)
    )
    println("Значения по индексу 1: ${data.getValueByIndex(1)}")
    println("Значения по индексу 2: ${data.getValueByIndex(2)}")
    println("С null: ${data.getValueByIndex(5)}")

    // === 4. within() ===
    println("5 within 6 ±1: ${5.within(6, 1)}") // true
    println("5 within 7 ±1: ${5.within(7, 1)}") // false
    println("3.14 within 3.1 ±0.05: ${3.14.within(3.1, 0.05)}") // false
    println("100L within 102 ±3: ${100L.within(102, 3)}") // true

    // === 5. encrypt / decrypt ===
    val original = "Hello"
    val encrypted = original.encrypt(3)
    val decrypted = encrypted.decrypt(3)
    println("Оригинал: $original")
    println("Зашифровано (+3): $encrypted")
    println("Расшифровано: $decrypted")
    println("Совпадает: ${original == decrypted}")

    // === 6. Twitter-игра ===
    val word = "kotlin"
    val users = listOf("alice", "bob", "carol", "dave", "eve", "mallory")
    println("\n=== Twitter-игра ===")
    word.printAsTwitterGame(users)
}