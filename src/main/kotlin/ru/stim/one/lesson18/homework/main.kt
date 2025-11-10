package ru.stim.one.lesson18.homework

import java.io.InputStream

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

fun main() {
    val fridge = Fridge(maxTemperature = 10, sensorType = "Temperature", maxSensoredValue = 8)
    val washingMachine = WashingMachineDevice(capacity = 60, maxTemperature = 95)
    val kettle = Kettle(capacity = 1, maxTemperature = 100)
    val oven = Oven(maxTemperature = 250)

    println("\n=== Холодильник ===")
    fridge.open()
    fridge.powerOn()
    fridge.open()
    fridge.setTemperature(4)
    fridge.cool()
    fridge.startMonitoring()
    fridge.powerOff()

    println("\n=== Стиральная машина ===")
    washingMachine.powerOn()
    washingMachine.open()
    washingMachine.close()
    washingMachine.setTemperature(60)
    washingMachine.fillWater(40)
    washingMachine.programAction("Хлопок 60°C")
    washingMachine.execute()
    washingMachine.startWash()
    washingMachine.drain()
    washingMachine.powerOff()

    println("\n=== Чайник ===")
    kettle.powerOn()
    kettle.open()
    kettle.fillWater(1)
    kettle.setTemperature(100)
    kettle.boil()
    kettle.programAction("Быстрое кипячение")
    kettle.execute()
    kettle.powerOff()

    println("\n=== Духовка ===")
    oven.powerOn()
    oven.open()
    oven.close()
    oven.setTemperature(180)
    oven.programAction("Выпечка пирога")
    oven.execute()
    oven.bake()
    oven.powerOff()
}
