package ru.stim.one.lesson14.homework

// 1. Событие: вечеринка
class Party(val location: String, val attendees: Int) {
    fun details() {
        println("Вечеринка пройдёт в: $location, гостей: $attendees")
    }
}