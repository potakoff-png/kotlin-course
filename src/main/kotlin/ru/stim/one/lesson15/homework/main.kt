package ru.stim.one.lesson15.homework

fun main() {
    // === Геометрические фигуры ===
    val circle = Circle(5.0)
    println("Круг: площадь = ${circle.area()}, периметр = ${circle.perimeter()}")

    val triangle = Triangle(3.0, 4.0, 5.0)
    println("Треугольник: площадь = ${triangle.area()}, периметр = ${triangle.perimeter()}")

    // === Учебные заведения ===
    val school = School("Школа №1", "ул. Ленина, 10", 1..11, 800)
    println("${school.name} — ${school.getLevel()}, студентов: ${school.getStudentCount()}")

    // === Мебель ===
    val table = Table("Дерево", "Коричневый", 120.0, 75.0, 80.0, 4)
    println("${table.material} стол: ${table.assemble()}")

    // === Контейнеры ===
    val bottomContainer = BottomInsertContainer()
    bottomContainer.addMaterialAtBottom("сталь")
    bottomContainer.addMaterialAtBottom("пластик")
    println("BottomInsert: $bottomContainer") // [пластик, сталь]

    val alternatingContainer = AlternatingInsertContainer()
    //alternatingContainer.materials.addAll(listOf("A", "B", "C"))
    alternatingContainer.addMaterialsAlternating(listOf("X", "Y"))
    println("Alternating: $alternatingContainer") // [X, A, Y, B, C]

    val sortedContainer = SortedInsertContainer()
    sortedContainer.addMaterialSorted("медь")
    sortedContainer.addMaterialSorted("алюминий")
    sortedContainer.addMaterialSorted("сталь")
    println("Sorted: $sortedContainer") // [алюминий, медь, сталь]

    val kvContainer = KeyValueInsertContainer()
    //kvContainer.materials.add("средний слой")
    kvContainer.addKeyValueMaterials(mapOf("ключ1" to "знач1", "ключ2" to "знач2"))
    println("KeyValue: $kvContainer") // [ключ2, ключ1, средний слой, знач1, знач2]
}