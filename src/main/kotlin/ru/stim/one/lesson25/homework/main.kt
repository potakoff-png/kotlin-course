package ru.stim.one.lesson25.homework

fun timeTracker(block: () -> List<Int>): Long {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    return end - start
}

val myFunction = {
    val list = List(1_000_000) { (0..10_000).random() }
    list.sorted()
}

val employee = Employee("Иван Петров", 35, "Разработчик")
    .apply {
        email = "ivan.petrov@alfainvest.ru"
        department = "IT"
    }

val executionTime = timeTracker(myFunction)


fun printPersonInfo(person: Person) {
    with(person) {
        println("""
            |=== Информация о персоне ===
            |Имя:      $name
            |Возраст:  $age
            |Email:    $email
            |============================
        """.trimMargin())
    }
}

val person = Person("Анна Смирнова", 28)
    .also {
        it.email = "anna.smirnova@alfainvest.ru"
    }
    .also(::printPersonInfo)

val personForConversion = Person("Дмитрий Козлов", 30)
    .apply { email = "dmitry.kozlov@alfainvest.ru" }

val employeeFromWith = with(personForConversion) {
    Employee(name, age, "Аналитик").apply {
        email = this@with.email
        department = "Аналитика"
    }
}


val employeeFromRun = personForConversion.run {
    Employee(name, age, "Старший аналитик").apply {
        email = this@run.email
        department = "Аналитика"
    }
}


fun Person?.toEmployee(position: String): Employee? {
    return this?.let { person ->
        Employee(person.name, person.age, position).apply {
            email = person.email
            department = "Общий"
        }
    }
}

// Примеры использования
val validPerson: Person? = Person("Елена Морозова", 33).apply { email = "elena.morozova@alfainvest.ru" }
val nullPerson: Person? = null

val emp1 = validPerson.toEmployee("Менеджер")
val emp2 = nullPerson.toEmployee("Менеджер")


fun main() {
    println("=== Задание 1: timeTracker ===")
    val myFunction = {
        val list = List(1_000_000) { (0..10_000).random() }
        list.sorted()
    }
    val time = timeTracker(myFunction)
    println("Время выполнения: $time мс\n")

    println("=== Задание 2: apply для Employee ===")
    val employee = Employee("Иван Петров", 35, "Разработчик")
        .apply {
            email = "ivan.petrov@alfainvest.ru"
            department = "IT"
        }
    println(employee)

    println("\n=== Задание 3: also + with для логирования ===")
    val person = Person("Анна Смирнова", 28)
        .also { it.email = "anna.smirnova@alfainvest.ru" }
        .also(::printPersonInfo)

    println("=== Задание 4: with — преобразование Person → Employee ===")
    val personForConversion = Person("Дмитрий Козлов", 30)
        .apply { email = "dmitry.kozlov@alfainvest.ru" }

    val employeeFromWith = with(personForConversion) {
        Employee(name, age, "Аналитик").apply {
            email = this@with.email
            department = "Аналитика"
        }
    }
    println(employeeFromWith)

    println("\n=== Задание 5: run — преобразование Person → Employee ===")
    val employeeFromRun = personForConversion.run {
        Employee(name, age, "Старший аналитик").apply {
            email = this@run.email
            department = "Аналитика"
        }
    }
    println(employeeFromRun)

    println("\n=== Задание 6: let — безопасное преобразование ===")
    val validPerson: Person? = Person("Елена Морозова", 33).apply { email = "elena.morozova@alfainvest.ru" }
    val nullPerson: Person? = null

    println("С null: ${nullPerson.toEmployee("Менеджер")}")
    println("Без null: ${validPerson.toEmployee("Менеджер")}")
}