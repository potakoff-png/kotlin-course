package ru.stim.one.lesson18.homework

abstract class BasePowerable : Powerable {
    protected var isPoweredOn = false

    override fun powerOn() {
        if (!isPoweredOn) {
            isPoweredOn = true
            println("${this::class.simpleName} включён.")
        } else {
            println("${this::class.simpleName} уже включён.")
        }
    }

    override fun powerOff() {
        if (isPoweredOn) {
            isPoweredOn = false
            println("${this::class.simpleName} выключен.")
        } else {
            println("${this::class.simpleName} уже выключен.")
        }
    }

    // Вспомогательный метод для проверки питания
    protected fun requirePower() = isPoweredOn
}