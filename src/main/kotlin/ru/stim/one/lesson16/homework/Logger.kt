package ru.stim.one.lesson16.homework

class Logger {
    // Базовый: INFO
    fun log(message: String) {
        println("[INFO] $message")
    }

    // Перегрузка: уровень + сообщение
    fun log(level: String, message: String) {
        when (level.uppercase()) {
            "WARNING" -> println("\u001b[33;1m[WARNING] $message\u001b[0m") // Жёлтый жирный
            "ERROR" -> println("\u001b[37;41m[ERROR] $message\u001b[0m")   // Белый на красном
            else -> println("[$level] $message")
        }
    }

    // Перегрузка: список сообщений (INFO)
    fun log(messages: List<String>) {
        messages.forEach { log(it) }
    }

    // Перегрузка: Exception
    fun log(exception: Exception) {
        log("ERROR", exception.message ?: "Unknown error")
    }
}