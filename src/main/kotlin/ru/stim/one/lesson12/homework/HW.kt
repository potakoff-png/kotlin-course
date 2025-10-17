package ru.stim.one.lesson12.homework

//Задачи на приведение коллекции к значению

fun checkSizeGreaterThanFive(collection: Collection<Int>): Boolean {
    return collection.size > 5
}

fun checkEmpty(collection: Collection<Int>): Boolean {
    return collection.isEmpty()
}

fun checkNotEmpty(collection: Collection<Int>): Boolean {
    return collection.isNotEmpty()
}

fun getElementOrElse(collection: List<Int>, index: Int, default: Int): Int {
    return collection.getOrNull(index) ?: default
}

fun joinToString(collection: Collection<String>): String {
    return collection.joinToString(separator = ", ")
}

fun sumValues(collection: Collection<Int>): Int {
    return collection.sum()
}

fun averageValue(collection: Collection<Int>): Double {
    return collection.average()
}

fun maxNumber(collection: Collection<Int>): Int? {
    return collection.maxOrNull()
}

fun minNumber(collection: Collection<Int>): Int? {
    return collection.minOrNull()
}

fun firstOrNull(collection: Collection<Int>): Int? {
    return collection.firstOrNull()
}

fun containsElement(collection: Collection<Int>, element: Int): Boolean {
    return collection.contains(element)
}

//Задачи на обработку коллекций

fun filterByAgeRange(ages: List<Int>): List<Int> {
    return ages.filter { it in 18..30 }
}

fun filterNotDivisibleBy2And3(numbers: List<Int>): List<Int> {
    return numbers.filter { !(it % 2 == 0 && it % 3 == 0) }
}

fun cleanNullStrings(strings: List<String?>): List<String> {
    return strings.filterNotNull()
}

fun mapToWordLengths(strings: List<String>): List<Int> {
    return strings.map { it.length }
}

fun mapToReversedWordAndLength(strings: List<String>): Map<String, Int> {
    return strings.associate { it.reversed() to it.length }
}

fun sortAlphabetically(strings: List<String>): List<String> {
    return strings.sorted()
}

fun takeFirstThree(strings: List<String>): List<String> {
    return strings.take(3)
}

fun printSquares(numbers: List<Int>) {
    numbers.forEach { println(it * it) }
}

fun groupByFirstLetter(strings: List<String>): Map<Char, List<String>> {
    return strings.groupBy { it.first().lowercaseChar() }
}

fun removeDuplicates(strings: List<String>): List<String> {
    return strings.distinct()
}

fun sortByDescending(numbers: List<Int>): List<Int> {
    return numbers.sortedDescending()
}

fun takeLastThree(strings: List<String>): List<String> {
    return strings.takeLast(3)
}

//Задача 24. Характеристика числовой коллекции
fun describeCollection(numbers: List<Int>): String {
    val sum = numbers.sum()
    val avg = if (numbers.isEmpty()) 0.0 else numbers.average()
    val joined = numbers.joinToString("")
    val max = numbers.maxOrNull()
    val min = numbers.minOrNull()

    return when {
        numbers.isEmpty() -> "Пусто"
        numbers.size < 5 -> "Короткая"
        numbers.firstOrNull() == 0 -> "Стартовая"
        sum > 10000 -> "Массивная"
        avg == 10.0 -> "Сбалансированная"
        joined.length == 20 -> "Клейкая"
        max != null && max < -10 -> "Отрицательная"
        min != null && min > 1000 -> "Положительная"
        numbers.contains(3) && numbers.contains(14) -> "Пи***тая"
        else -> "Уникальная"
    }
}

// Пример вызовов:
fun testDescribeCollection() {
    println(describeCollection(emptyList())) // Пусто
    println(describeCollection(listOf(1, 2))) // Короткая
    println(describeCollection(listOf(0, 1, 2, 3))) // Стартовая
    println(describeCollection((1..1000).toList())) // Массивная
    println(describeCollection(listOf(10, 10, 10))) // Сбалансированная
    println(describeCollection(listOf(123, 456, 789, 12))) // Клейкая (если длина строки = 20)
    println(describeCollection(listOf(-15, -20))) // Отрицательная
    println(describeCollection(listOf(1001, 1002))) // Положительная
    println(describeCollection(listOf(3, 14, 5))) // Пи***тая
    println(describeCollection(listOf(5, 6, 7))) // Уникальная
}

//Задача 25. Анализ учебных оценок

fun analyzeGrades(grades: List<Int>): List<Int> {
    return grades
        .filter { it >= 60 }
        .sorted()
        .take(3)
}

// Вызов:
val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)

//Задача 26. Создание каталога по первой букве

fun createCatalogByFirstLetter(items: List<String>): Map<Char, List<String>> {
    return items
        .map { it.lowercase() }
        .groupBy { it.first() }
}

// Вызов:
val list = listOf(
    "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
)

//Задание 27. Подсчёт средней длины слов

fun averageWordLength(items: List<String>): String {
    val avg = items
        .map { it.length }
        .average()
    return "Средняя длина слова: ${"%.2f".format(avg)} символов"
}

//Задание 28. Категоризация чисел

fun categorizeNumbers(numbers: List<Int>): Map<String, List<Int>> {
    return numbers
        .distinct()
        .sortedDescending()
        .groupBy { if (it % 2 == 0) "четные" else "нечетные" }
}

// Вызов:
val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)

//Задание 29. Поиск первого подходящего элемента

fun findFirstAgeGreaterThan(ages: List<Int?>, threshold: Int): Int? {
    return ages.firstOrNull { it != null && it > threshold }
}

// Вызов:
val ages = listOf(22, 18, 30, 45, 17, null, 60)

