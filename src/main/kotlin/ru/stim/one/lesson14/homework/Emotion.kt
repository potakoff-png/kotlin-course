package ru.stim.one.lesson14.homework

// 2. Аспект реальности: эмоция
class Emotion(val type: String, val intensity: Int) {
    fun express() {
        println("Чувствую $type с интенсивностью $intensity")
    }
}