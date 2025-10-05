package ru.stim.one.lesson09.homework

fun main() {
    println("1. Массив Int: [1, 2, 3, 4, 5]")
    println("2. Пустой массив строк (10 элементов) создан")
    println("3. Double массив: ${Array(5) { (it * 2).toDouble() }.contentToString()}")
    println("4. Умножение на 3: ${Array(5) { it * 3 }.contentToString()}")

    val nullableStrings = arrayOf<String?>("Привет", null, "Мир")
    println("5. Nullable строки: ${nullableStrings.contentToString()}")

    // Копирование
    val source = arrayOf(10, 20, 30, 40, 50)
    val target = Array(source.size) { 0 }
    var i = 0
    while (i < source.size) {
        target[i] = source[i]
        i++
    }
    println("6. Скопировано: ${target.contentToString()}")

    // Разность
    val a1 = arrayOf(10, 20, 30, 40, 50)
    val a2 = arrayOf(1, 5, 10, 15, 20)
    val diff = Array(a1.size) { a1[it] - a2[it] }
    println("7. Разность: ${diff.contentToString()}")

    // Поиск индекса 5
    val nums1 = arrayOf(2, 7, 5, 9, 1)
    var idx = 0
    var found1 = -1
    while (idx < nums1.size) {
        if (nums1[idx] == 5) {
            found1 = idx
            break
        }
        idx++
    }
    println("8. Индекс значения 5: $found1")

    // Чётное/нечётное
    println("9. Проверка чётности:")
    arrayOf(1, 4, 7, 8, 10).forEach {
        println("$it — ${if (it % 2 == 0) "чётное" else "нечётное"}")
    }

    println("1. Пустой неизменяемый список: ${emptyList<Int>()}")

    val strings = listOf("Hello", "World", "Kotlin")
    println("2. Неизменяемый список: $strings")

    val mutableNumbers = mutableListOf(1, 2, 3, 4, 5)
    println("3. Изменяемый список: $mutableNumbers")

    mutableNumbers.addAll(listOf(6, 7, 8))
    println("4. После добавления: $mutableNumbers")

    val mutableStrList = mutableListOf("Hello", "World", "Kotlin")
    mutableStrList.remove("World")
    println("5. После удаления 'World': $mutableStrList")

    println("6. Вывод элементов:")
    for (n in mutableNumbers) println(n)

    println("7. Второй элемент: ${strings.getOrNull(1) ?: "отсутствует"}")

    val changeable = mutableListOf(10, 20, 30, 40)
    if (changeable.size > 2) {
        changeable[2] = 99
        println("8. После замены: $changeable")
    }

    val merged = mutableListOf<String>()
    for (s in listOf("A", "B")) merged.add(s)
    for (s in listOf("C", "D")) merged.add(s)
    println("9. Объединённый список: $merged")

    val nums = listOf(5, 3, 9, 1, 7)
    if (nums.isNotEmpty()) {
        var min = nums[0]; var max = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] < min) min = nums[i]
            if (nums[i] > max) max = nums[i]
        }
        println("10. Мин: $min, Макс: $max")
    }

    val evenOnly = mutableListOf<Int>()
    for (n in listOf(1, 2, 3, 4, 5, 6)) {
        if (n % 2 == 0) evenOnly.add(n)
    }
    println("11. Чётные: $evenOnly")

    println("1. Пустое неизменяемое множество: ${emptySet<Int>()}")

    val immutableSet = setOf(1, 2, 3)
    println("2. Неизменяемое множество: $immutableSet")

    val mutableSet = mutableSetOf("Kotlin", "Java", "Scala")
    println("3. Изменяемое множество: $mutableSet")

    mutableSet.add("Swift")
    mutableSet.add("Go")
    println("4. После добавления: $mutableSet")

    val intSet = mutableSetOf(1, 2, 3, 4, 5)
    intSet.remove(2)
    println("5. После удаления 2: $intSet")

    println("6. Вывод элементов множества:")
    setOf(10, 20, 30).forEach { println(it) }

    val sourceSet = setOf("Alpha", "Beta", "Gamma")
    val targetList = mutableListOf<String>()
    for (item in sourceSet) {
        targetList.add(item)
    }
    println("8. Преобразовано в список: $targetList")

}

    fun test(){
    val intArray = arrayOf(1, 2, 3, 4, 5)

    val stringArray = arrayOfNulls<String>(10) // Можно использовать String?, если нужны null
    // Или, если требуется именно не-null тип, инициализируем пустыми строками:
    val stringArrayEmpty = Array(10) { "" }

    val doubleArray = Array(5) { index -> (index * 2).toDouble() }
    // Результат: [0.0, 2.0, 4.0, 6.0, 8.0]

    val multipliedArray = Array(5) { index -> index * 3 }
    // Результат: [0, 3, 6, 9, 12]

    val nullableStrings = arrayOf<String?>("Привет", null, "Мир")

    val source = arrayOf(10, 20, 30, 40, 50)
    val target = Array(source.size) { 0 }

    var i = 0
    while (i < source.size) {
        target[i] = source[i]
        i++
}

    println("Скопированный массив: ${target.contentToString()}")

        val array1 = arrayOf(10, 20, 30, 40, 50)
        val array2 = arrayOf(1, 5, 10, 15, 20)
        val resultArray = Array(array1.size) { 0 }

        for (j in array1.indices) {
            resultArray[j] = array1[j] - array2[j]
        }

        println("Разность массивов: ${resultArray.contentToString()}")
        // Результат: [9, 15, 20, 25, 30]

        val numbers = arrayOf(2, 7, 5, 9, 1)
        var index = 0
        var foundIndex = -1

        while (index < numbers.size) {
            if (numbers[index] == 5) {
                foundIndex = index
                break
            }
            index++
        }

        println("Индекс элемента со значением 5: $foundIndex")

        val nums = arrayOf(1, 4, 7, 8, 10)

        for (num in nums) {
            val parity = if (num % 2 == 0) "чётное" else "нечётное"
            println("$num — $parity")
        }

        fun findSubstringInArray(strings: Array<String>, substring: String) {
            var k = 0
            while (k < strings.size) {
                if (strings[k].contains(substring, ignoreCase = true)) {
                    println("Найдено: ${strings[k]}")
                    return
                }
                k++
            }
            println("Элемент не найден")
        }

        // Пример использования
        fun test1() {
            val stringArray = arrayOf("Котлин", "Java", "Python", "JavaScript")
            findSubstringInArray(stringArray, "ava") // Найдёт "Java"
        }

        val emptyList: List<Int> = emptyList()
        // или
        val emptyListAlt = listOf<Int>()

        val immutableStrings = listOf("Hello", "World", "Kotlin")

        val mutableIntList = mutableListOf(1, 2, 3, 4, 5)

        mutableIntList.add(6)
        mutableIntList.addAll(listOf(7, 8))
        // или
        mutableIntList += 6
        mutableIntList += listOf(7, 8)

        val mutableStringList = mutableListOf("Hello", "World", "Kotlin")
        mutableStringList.remove("World")

        val numbers1 = listOf(1, 2, 3, 4, 5)
        for (num in numbers1) {
            println(num)
        }

        val strings = listOf("Hello", "World", "Kotlin")
        if (strings.size > 1) {
            val secondElement = strings[1] // Индексация с 0 → второй элемент — индекс 1
            println("Второй элемент: $secondElement")
        } else {
            println("Список слишком короткий")
        }

        val numbersList = mutableListOf(10, 20, 30, 40, 50)
        if (numbersList.size > 2) {
            numbersList[2] = 99 // Заменяем элемент с индексом 2
            println("Список после замены: ${numbersList}")
        }

        val list1 = listOf("A", "B", "C")
        val list2 = listOf("D", "E", "F")
        val mergedList = mutableListOf<String>()

        for (item in list1) {
            mergedList.add(item)
        }
        for (item in list2) {
            mergedList.add(item)
        }

        println("Объединённый список: $mergedList")

        val numList = listOf(5, 3, 9, 1, 7)

        if (numList.isEmpty()) {
            println("Список пуст")
        } else {
            var min = numList[0]
            var max = numList[0]

            for (i in 1 until numList.size) {
                val current = numList[i]
                if (current < min) min = current
                if (current > max) max = current
            }

            println("Минимальный: $min, Максимальный: $max")
        }

        val originalList = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val evenList = mutableListOf<Int>()

        for (num in originalList) {
            if (num % 2 == 0) {
                evenList.add(num)
            }
        }

        println("Чётные числа: $evenList")

        val emptySet: Set<Int> = emptySet()
        // или
        val emptySetAlt = setOf<Int>()

        val immutableSet = setOf(1, 2, 3)

        val mutableStringSet = mutableSetOf("Kotlin", "Java", "Scala")

        mutableStringSet.add("Swift")
        mutableStringSet.addAll(listOf("Go"))
        // или
        mutableStringSet += "Swift"
        mutableStringSet += "Go"

        val mutableIntSet = mutableSetOf(1, 2, 3, 4, 5)
        mutableIntSet.remove(2)

        val numberSet = setOf(10, 20, 30, 40, 50)
        for (num in numberSet) {
            println(num)
        }

        fun containsString(set: Set<String>, searchString: String): Boolean {
            for (element in set) {
                if (element == searchString) {
                    return true
                }
            }
            return false
        }

        //Пример использования:
        val result = containsString(mutableStringSet, "Kotlin") // вернёт true

        val stringSet = setOf("Alpha", "Beta", "Gamma")
        val mutableStringList1 = mutableListOf<String>()

        for (item in stringSet) {
            mutableStringList.add(item)
        }

        // Теперь mutableStringList содержит все элементы из множества
        println("Список: $mutableStringList")

}
