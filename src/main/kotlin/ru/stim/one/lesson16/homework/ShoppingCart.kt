package ru.stim.one.lesson16.homework

class ShoppingCart {
    private val items = mutableMapOf<String, Int>()

    // Базовый метод: добавить 1 штуку
    fun addToCart(itemId: String) {
        items[itemId] = items.getOrDefault(itemId, 0) + 1
    }

    // Перегрузка: добавить указанное количество
    fun addToCart(itemId: String, amount: Int) {
        if (amount > 0) {
            items[itemId] = items.getOrDefault(itemId, 0) + amount
        }
    }

    // Перегрузка: добавить словарь
    fun addToCart(itemMap: Map<String, Int>) {
        itemMap.forEach { (id, amount) ->
            if (amount > 0) {
                addToCart(id, amount)
            }
        }
    }

    // Перегрузка: добавить список ID (по 1 штуке)
    fun addToCart(itemIds: List<String>) {
        itemIds.forEach { id ->
            addToCart(id)
        }
    }

    // Переопределение toString
    override fun toString(): String {
        if (items.isEmpty()) return "Корзина пуста."

        val header = "%-10s | %-5s".format("Артикул", "Кол-во")
        val separator = "-".repeat(20)
        val rows = items.entries.joinToString("\n") { (id, qty) ->
            "%-10s | %-5d".format(id, qty)
        }

        val totalItems = items.values.sum()
        val totalSkus = items.size

        return """
            $header
            $separator
            $rows
            $separator
            Итого: $totalSkus артикулов, $totalItems шт.
        """.trimIndent()
    }
}