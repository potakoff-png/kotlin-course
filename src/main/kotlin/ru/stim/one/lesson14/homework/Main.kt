package ru.stim.one.lesson14.homework

// === Пример использования ===
fun main() {
    // 1. Party
    val party = Party("Дача", 15)
    party.details()

    // 2. Emotion
    val emotion = Emotion("Радость", 9)
    emotion.express()

    // 3. Moon
    Moon.showPhase()

    // 4. Product
    val product = Product("Ноутбук", 999.99, 5)
    println("Товар: $product")

    // 5. Concert
    val concert = Concert("The Rolling Stones", "Stadium", 5000.0, 50000)
    concert.concertInfo()
    concert.buyTicket()
    concert.concertInfo()

    // 6. Rack & Shelf
    val rack = Rack(maxShelves = 3)
    val shelf1 = Shelf(20) // Вместимость 20 символов
    val shelf2 = Shelf(15)
    val shelf3 = Shelf(10)

    rack.addShelf(shelf1)
    rack.addShelf(shelf2)
    rack.addShelf(shelf3)

    // Добавляем предметы
    println("Добавлено 'книга': ${rack.addItem("книга")}")           // 4
    println("Добавлено 'ноутбук': ${rack.addItem("ноутбук")}")       // 7 → 4+7=11
    println("Добавлено 'телефон': ${rack.addItem("телефон")}")       // 8 → 11+8=19
    println("Добавлено 'наушники': ${rack.addItem("наушники")}")     // 9 → не влезет

    rack.printContents()

    println("Есть 'книга'? ${rack.containsItem("книга")}")
    println("Удалён 'телефон'? ${rack.removeItem("телефон")}")

    // Продвинутое удаление полки
    val failed = rack.advancedRemoveShelf(0)
    println("Не удалось переразместить: $failed")

    rack.printContents()
}