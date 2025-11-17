package ru.stim.one.lesson19.homework

// 1. Функция getMiddleElement — возвращает средний элемент списка или null
fun <T> getMiddleElement(list: List<T>): T? {
    if (list.isEmpty()) return null
    val midIndex = list.size / 2
    return if (list.size % 2 == 1) list[midIndex] else null
}

// 2. Класс ListHolder — хранит список и предоставляет безопасный доступ
class ListHolder<T> {
    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> = items.toList() // неизменяемый список
}

// 3. Интерфейс Mapper — преобразование типов
interface Mapper<From, To> {
    fun map(item: From): To
    fun mapList(list: List<From>): List<To>
}

// 4. Реализация Mapper: String -> List<String>
class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun map(item: String): List<String> {
        return item.split("\\s+".toRegex()).filter { it.isNotBlank() }
    }

    override fun mapList(list: List<String>): List<List<String>> {
        return list.map { map(it) }
    }
}

// 5. Функция transposition — меняет местами ключ и значение в Map
fun <K, V> transposition(map: Map<K, V>): Map<V, K> {
    return map.entries.associate { (key, value) -> value to key }
}

// 6. Интерфейс Validator
interface Validator<T> {
    fun validate(value: T): Boolean
}

// 7. Валидатор для String? — не null, не пустая, не пробелы
class StringValidator : Validator<String?> {
    override fun validate(value: String?): Boolean {
        return value != null && value.isNotBlank()
    }
}

// 8. Валидатор для Int — проверка на чётность
class OddValidator : Validator<Int> {
    override fun validate(value: Int): Boolean {
        return value % 2 == 0 // true, если чётное
    }
}

// 9. Валидатор для List<T?>, где T: Number
class ListValidator<T : Number> : Validator<List<T?>> {
    override fun validate(value: List<T?>): Boolean {
        if (value.isEmpty()) return true // можно считать валидным или по договорённости

        return value.all { it != null } && value.all {
            val doubleValue = it?.toDouble() ?: return false
            doubleValue != 0.0
        }
    }
}

fun main() {
    // === 1. getMiddleElement ===
    println("Средний элемент [1,2,3]: ${getMiddleElement(listOf(1, 2, 3))}") // 2
    println("Средний элемент [1,2,3,4]: ${getMiddleElement(listOf(1, 2, 3, 4))}") // null
    println("Средний элемент пустого списка: ${getMiddleElement(emptyList<String>())}") // null

    // === 2. ListHolder ===
    val holder = ListHolder<String>()
    holder.add("Alpha")
    holder.add("Beta")
    println("Все элементы: ${holder.getAll()}")

    // === 3. PhrasesToListOfStrings (Mapper) ===
    val mapper = PhrasesToListOfStrings()
    println("Разбивка фразы: ${mapper.map("Hello  world   Kotlin")}")
    println("Разбивка списка фраз: ${mapper.mapList(listOf("a b c", "x  y", ""))}")

    // === 4. transposition ===
    val originalMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    val transposed = transposition(originalMap)
    println("Транспонированный словарь: $transposed") // {1=one, 2=two, 3=three}

    // === 5. StringValidator ===
    val stringValidator = StringValidator()
    println("Валидна ли 'Hello'? ${stringValidator.validate("Hello")}") // true
    println("Валидна ли '   '? ${stringValidator.validate("   ")}") // false
    println("Валидна ли null? ${stringValidator.validate(null)}") // false

    // === 6. OddValidator ===
    val oddValidator = OddValidator()
    println("Число 4 чётное? ${oddValidator.validate(4)}") // true
    println("Число 7 чётное? ${oddValidator.validate(7)}") // false

    // === 7. ListValidator ===
    val listValidator = ListValidator<Double>()
    println("Список [1.0, 2.0, 3.0] валиден? ${listValidator.validate(listOf(1.0, 2.0, 3.0))}") // true
    println("Список [1.0, 0.0, 3.0] валиден? ${listValidator.validate(listOf(1.0, 0.0, 3.0))}") // false
    println("Список [1.0, null, 3.0] валиден? ${listValidator.validate(listOf(1.0, null, 3.0))}") // false
    println("Пустой список валиден? ${listValidator.validate(emptyList())}") // true
}