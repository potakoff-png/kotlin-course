package ru.stim.one.lesson18.homework

abstract class BaseTemperatureOpenable : BaseProgrammable(), Openable, TemperatureRegulatable {
    protected var isOpen = false
    protected var currentTemperature = 0

    override fun open() {
        if (!requirePower()) {
            println("Невозможно открыть: устройство выключено.")
            return
        }
        if (!isOpen) {
            isOpen = true
            println("Устройство открыто.")
        } else {
            println("Устройство уже открыто.")
        }
    }

    override fun close() {
        if (isOpen) {
            isOpen = false
            println("Устройство закрыто.")
        } else {
            println("Устройство уже закрыто.")
        }
    }

    override fun setTemperature(temp: Int) {
        if (!requirePower()) {
            println("Невозможно установить температуру: устройство выключено.")
            return
        }
        if (temp > maxTemperature) {
            println("Ошибка: температура $temp превышает максимум: $maxTemperature")
            return
        }
        currentTemperature = temp
        println("Температура установлена: $temp°C")
    }
}