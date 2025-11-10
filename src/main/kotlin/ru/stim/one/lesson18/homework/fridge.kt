package ru.stim.one.lesson18.homework

class Fridge(override val maxTemperature: Int, override val sensorType: String, override val maxSensoredValue: Int) :
    BaseTemperatureOpenable(), AutomaticShutdown {

    override fun startMonitoring() {
        if (!requirePower()) {
            println("Мониторинг не запущен: устройство выключено.")
            return
        }
        println("Запущен мониторинг $sensorType. Порог: $maxSensoredValue")
    }

    fun cool() {
        if (!requirePower()) {
            println("Охлаждение невозможно: устройство выключено.")
            return
        }
        if (isOpen) {
            println("Нельзя охлаждать: дверца открыта.")
            return
        }
        println("Холодильник охлаждает содержимое.")
    }
}

class WashingMachineDevice(
    override val capacity: Int,
    override val maxTemperature: Int
) : BaseTemperatureOpenable(), WaterContainer, Drainable {

    override fun fillWater(amount: Int) {
        if (!requirePower()) {
            println("Невозможно налить воду: устройство выключено.")
            return
        }
        println("Наливаем $amount л воды (ёмкость: $capacity л)")
    }

    override fun getWater(amount: Int) {
        println("Забираем $amount л воды")
    }

    override fun connectToDrain() {
        println("Подключено к канализации")
    }

    override fun drain() {
        if (!requirePower()) {
            println("Слив невозможен: устройство выключено.")
            return
        }
        println("Выполняем слив воды")
    }

    fun startWash() {
        if (!requirePower()) {
            println("Стирка невозможна: устройство выключено.")
            return
        }
        if (isOpen) {
            println("Стирка невозможна: люк открыт.")
            return
        }
        println("Запущена стирка при ${currentTemperature}°C")
    }
}

class Kettle(override val capacity: Int, override val maxTemperature: Int) : BaseTemperatureOpenable(), WaterContainer {

    override fun fillWater(amount: Int) {
        if (!requirePower()) {
            println("Невозможно налить воду: устройство выключено.")
            return
        }
        println("Наливаем $amount л воды в чайник (ёмкость: $capacity л)")
    }

    override fun getWater(amount: Int) {
        println("Наливаем $amount л кипятка")
    }

    fun boil() {
        if (!requirePower()) {
            println("Кипячение невозможно: устройство выключено.")
            return
        }
        if (currentTemperature < 100) {
            setTemperature(100)
        }
        println("Чайник кипятит воду...")
    }
}

class Oven(override val maxTemperature: Int) : BaseTemperatureOpenable() {

    fun bake() {
        if (!requirePower()) {
            println("Выпечка невозможна: устройство выключено.")
            return
        }
        if (isOpen) {
            println("Нельзя выпекать: дверца открыта.")
            return
        }
        println("Духовка выпекает при ${currentTemperature}°C")
    }
}