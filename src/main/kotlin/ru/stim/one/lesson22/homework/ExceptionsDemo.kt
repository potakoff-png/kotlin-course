package ru.stim.one.lesson22.homework

fun main() {
    // Задание 9: Обернуть вызовы в try-catch с отдельными блоками
    println("=== Задание 9: Перехват конкретных исключений ===")

    // 1. NullPointerException (в Kotlin — через !!)
    try {
        val nullString: String? = null
        println(nullString!!.length)
    } catch (e: NullPointerException) {
        println("Перехвачен NullPointerException: ${e.message}")
    }

    // 2. IndexOutOfBoundsException
    try {
        val list = listOf(1, 2, 3)
        println(list[5])
    } catch (e: IndexOutOfBoundsException) {
        println("Перехвачен IndexOutOfBoundsException: ${e.message}")
    }

    // 3. ClassCastException
    try {
        val any: Any = "Это строка"
        val number: Int = any as Int
    } catch (e: ClassCastException) {
        println("Перехвачен ClassCastException: ${e.message}")
    }

    // 4. IllegalArgumentException
    try {
        require(2 + 2 == 5) { "Математика сломалась" }
    } catch (e: IllegalArgumentException) {
        println("Перехвачен IllegalArgumentException: ${e.message}")
    }

    // 5. NumberFormatException
    try {
        "abc".toInt()
    } catch (e: NumberFormatException) {
        println("Перехвачен NumberFormatException: ${e.message}")
    }

    // 6. IllegalStateException
    try {
        error("Что-то пошло не так")
    } catch (e: IllegalStateException) {
        println("Перехвачен IllegalStateException: ${e.message}")
    }

    // 7. OutOfMemoryError
    try {
        (0..Long.MAX_VALUE).map { Long.MAX_VALUE }
    } catch (e: OutOfMemoryError) {
        println("It is OutOfMemoryError! \uD83C\uDF89")
    }

    // 8. StackOverflowError
    try {
        fun recurse(): Int = recurse()
        recurse()
    } catch (e: StackOverflowError) {
        println("Перехвачен StackOverflowError: ${e.message}")
    }

    // Задание 10: Универсальная функция с анализом исключений
    println("\n=== Задание 10: Анализ исключений через Throwable ===")
    testArgument(null)
    testArgument("Hello")
    testArgument(listOf(1, 2, 3))
    testArgument(123)
    testArgument("not-a-number")
    testArgument(true)

    // Задание 11: Выброс пользовательского AssertionError
    println("\n=== Задание 11: Выброс MyAssertionError ===")
    try {
        throw MyAssertionError("Это моё пользовательское утверждение провалилось")
    } catch (e: MyAssertionError) {
        println("Перехвачено: ${e.message}")
    }

    // Задание 12: Выброс пользовательского RuntimeException с cause
    println("\n=== Задание 12: Перехват IndexOutOfBoundsException и выброс MyIndexException ===")
    try {
        val list = listOf("a", "b")
        println(list[5])
    } catch (e: IndexOutOfBoundsException) {
        println("Изначальная ошибка: ${e.message}")
        throw MyIndexException("Доступ за пределы списка", e)
    }
}

fun testArgument(arg: Any?) {
    try {
        // 1. NullPointerException
        val str: String = arg as String // ClassCastException, если не String
        println("Длина строки: ${str.length}") // NPE, если str == null

        // 2. IndexOutOfBoundsException
        if (str.length >= 5) {
            println("Шестой символ: ${str[5]}")
        }

        // 3. ClassCastException — уже был выше при приведении

        // 4. IllegalArgumentException
        require(str.isNotBlank()) { "Строка не должна быть пустой" }

        // 5. NumberFormatException
        val num = str.trim().toInt() // Попытка преобразовать строку в число

        // 6. IllegalStateException
        if (num < 0) {
            error("Число не может быть отрицательным")
        }

        println("Аргумент фантастически хорош! Значение: $arg")

    } catch (t: Throwable) {
        when (t) {
            is NullPointerException -> println("Ошибка: NullPointerException")
            is IndexOutOfBoundsException -> println("Ошибка: IndexOutOfBoundsException")
            is ClassCastException -> println("Ошибка: ClassCastException")
            is IllegalArgumentException -> println("Ошибка: IllegalArgumentException")
            is NumberFormatException -> println("Ошибка: NumberFormatException")
            is IllegalStateException -> println("Ошибка: IllegalStateException")
            else -> println("Неизвестная ошибка: ${t::class.simpleName}")
        }
        throw t // Прерываем выполнение
    }
}