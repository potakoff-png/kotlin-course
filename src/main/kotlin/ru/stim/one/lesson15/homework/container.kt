package ru.stim.one.lesson15.homework

// Абстрактный контейнер — нельзя создавать напрямую
abstract class Container {
    protected val materials = mutableListOf<String>()

    fun getMaterials(): List<String> = materials.toList()

    override fun toString(): String = "Container(materials=$materials)"
}

// 1. Вставляет строку на дно (индекс 0)
class BottomInsertContainer : Container() {
    fun addMaterialAtBottom(material: String) {
        materials.add(0, material)
    }
}

// 2. Вставляет список строк поочерёдно: 0, 2, 4... (чередуя с существующими)
class AlternatingInsertContainer : Container() {
    fun addMaterialsAlternating(newMaterials: List<String>) {
        var index = 0
        for (material in newMaterials) {
            if (index > materials.size) break
            materials.add(index, material)
            index += 2
        }
    }
}

// 3. Добавляет строку и сортирует весь список в алфавитном порядке
class SortedInsertContainer : Container() {
    fun addMaterialSorted(material: String) {
        materials.add(material)
        materials.sort()
    }
}

// 4. Принимает словарь: ключи в начало (в обратном порядке), значения в конец
class KeyValueInsertContainer : Container() {
    fun addKeyValueMaterials(entries: Map<String, String>) {
        val keysReversed = entries.keys.reversed()
        val values = entries.values.toList()

        materials.addAll(0, keysReversed)
        materials.addAll(values)
    }
}