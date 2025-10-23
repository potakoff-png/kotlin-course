package ru.stim.one.lesson14.homework

// 6. Система управления стеллажом

// Класс Стеллаж (Rack)
class Rack(private val maxShelves: Int) {
    private val shelves = mutableListOf<Shelf>()

    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.size >= maxShelves || shelves.contains(shelf)) {
            return false
        }
        shelves.add(shelf)
        return true
    }

    fun removeShelf(index: Int): List<String> {
        if (index !in shelves.indices) return emptyList()
        return shelves.removeAt(index).getItems()
    }

    fun addItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.addItem(item)) {
                return true
            }
        }
        return false
    }

    fun removeItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.removeItem(item)) {
                return true
            }
        }
        return false
    }

    fun containsItem(item: String): Boolean {
        return shelves.any { it.containsItem(item) }
    }

    fun getShelves(): List<Shelf> {
        return shelves.toList()
    }

    fun printContents() {
        println("\n=== Содержимое стеллажа ===")
        shelves.forEachIndexed { index, shelf ->
            val used = shelf.getItems().sumOf { it.length }
            val remaining = shelf.capacity - used
            println(
                "Полка $index | Вместимость: ${shelf.capacity} | Осталось: $remaining | " +
                        "Предметы: ${shelf.getItems()}"
            )
        }
        println("============================\n")
    }

    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) return emptyList()

        val shelfToRemove = shelves.removeAt(index)
        val itemsToRelocate = shelfToRemove.getItems().sortedByDescending { it.length }
        val failedItems = mutableListOf<String>()

        for (item in itemsToRelocate) {
            var placed = false
            for (shelf in shelves) {
                if (shelf.addItem(item)) {
                    placed = true
                    break
                }
            }
            if (!placed) {
                failedItems.add(item)
            }
        }

        return failedItems.toList()
    }
}