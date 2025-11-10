package ru.stim.one.lesson18.homework

abstract class BaseProgrammable : BasePowerable(), Programmable {
    private var currentAction: String? = null

    override fun programAction(action: String) {
        if (!requirePower()) {
            println("Невозможно запрограммировать: устройство выключено.")
            return
        }
        currentAction = action
        println("Действие запрограммировано: $action")
    }

    override fun execute() {
        if (!requirePower()) {
            println("Невозможно выполнить: устройство выключено.")
            return
        }
        if (currentAction == null) {
            println("Нет запрограммированного действия.")
            return
        }
        println("Выполнение: $currentAction")
    }
}