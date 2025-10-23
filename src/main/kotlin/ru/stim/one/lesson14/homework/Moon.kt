package ru.stim.one.lesson14.homework

// 3. Природное явление: луна (объект)
object Moon {
    val isVisible: Boolean = true
    val phase: String = "Full Moon"

    fun showPhase() {
        if (isVisible) {
            println("Сейчас фаза Луны: $phase")
        } else {
            println("Луна не видна")
        }
    }
}