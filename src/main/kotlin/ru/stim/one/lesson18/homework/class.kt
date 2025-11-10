package ru.stim.one.lesson18.homework

abstract class Refrigerator : Powerable, Openable, TemperatureRegulatable, AutomaticShutdown

abstract class WashingMachine : Powerable, Openable, WaterContainer, TemperatureRegulatable, Drainable, Timable

abstract class SmartLamp : Powerable, LightEmitting, Programmable, Rechargeable

abstract class ElectronicClock : Powerable, Timable, SoundEmitting

abstract class VacuumRobot : Powerable, Programmable, Movable, Cleanable, Rechargeable

abstract class MechanicalClock : Openable, Mechanical, Timable

abstract class Flashlight : Powerable, LightEmitting, BatteryOperated

abstract class CoffeeMachine : Powerable, WaterContainer, TemperatureRegulatable, Programmable

abstract class SmartSpeaker : Powerable, SoundEmitting, Programmable, Rechargeable