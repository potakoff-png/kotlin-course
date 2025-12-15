package ru.stim.one.lesson27.homework

//ex 1
enum class TestStatus {
    PASSED, FAILED, BROKEN
}
enum class PropertyType(val humanReadableName: String) {
    APARTMENT("Квартира"),
    HOUSE("Дом"),
    STUDIO("Студия"),
    LOFT("Лофт"),
    PENTHOUSE("Пентхаус"),
    TOWNHOUSE("Таунхаус")
}
enum class Planet(
    val distanceFromSunAU: Double,
    val massEarthUnits: Double
) {
    MERCURY(0.39, 0.055),
    VENUS(0.72, 0.815),
    EARTH(1.00, 1.000),
    MARS(1.52, 0.107),
    JUPITER(5.20, 317.8),
    SATURN(9.58, 95.2),
    URANUS(19.22, 14.5),
    NEPTUNE(30.05, 17.1)
}

//ex 2
fun printPropertyTypesSortedByLength() {
    PropertyType.values()
        .sortedBy { it.humanReadableName.length }
        .forEach { println(it.humanReadableName) }
}

//ex 3
fun runTest(testBody: () -> Unit): TestStatus {
    return try {
        testBody()
        TestStatus.PASSED
    } catch (e: AssertionError) {
        TestStatus.FAILED
    } catch (e: Throwable) {
        TestStatus.BROKEN
    }
}

//ex 4
fun findPlanet(predicate: (Planet) -> Boolean): Planet {
    return Planet.values()
        .filter(predicate)
        .firstOrNull()
        ?: throw NoSuchElementException("Не найдено ни одной планеты по заданному условию")
}

fun main() {
    println("=== Задание 2: Типы недвижимости по длине ===")
    printPropertyTypesSortedByLength()

    println("\n=== Задание 3: Выполнение тестов ===")

    println("Тест прошёл: ${runTest { println("OK") }}")
    println("Тест провален (AssertionError): ${runTest { require(false) }}")
    println("Тест сломан (другая ошибка): ${runTest { throw RuntimeException("crash") }}")

    println("\n=== Задание 4: Поиск планет ===")

    try {
        val distantPlanet = findPlanet { it.distanceFromSunAU > 20 }
        println("Планета за 20 а.е.: $distantPlanet")

        val massivePlanet = findPlanet { it.massEarthUnits > 100 }
        println("Планета тяжелее 100 Земель: $massivePlanet")

        val smallPlanet = findPlanet { it.massEarthUnits < 0.01 }
        println("Очень лёгкая планета: $smallPlanet")
    } catch (e: NoSuchElementException) {
        println("Ошибка: ${e.message}")
    }
}