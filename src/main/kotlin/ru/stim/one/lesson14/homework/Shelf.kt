package ru.stim.one.lesson14.homework

// 6. Система управления стеллажом

// Класс Полка (Shelf)
class Shelf(val capacity: Int) {
    private val items = mutableListOf<String>()

    val totalLength: Int
        get() = items.sumOf { it.length }

    fun addItem(item: String): Boolean {
        if (canAccommodate(item)) {
            items.add(item)
            return true
        }
        return false
    }

    fun removeItem(item: String): Boolean {
        return items.remove(item)
    }

    fun canAccommodate(item: String): Boolean {
        return totalLength + item.length <= capacity
    }

    fun containsItem(item: String): Boolean {
        return items.contains(item)
    }

    fun getItems(): List<String> {
        return items.toList()
    }
}