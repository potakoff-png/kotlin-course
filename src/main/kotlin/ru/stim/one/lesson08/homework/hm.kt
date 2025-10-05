package ru.stim.one.lesson08.homework

fun main(){
    val testPhrases = listOf(
        "Это невозможно выполнить за один день",
        "Я не уверен в успехе этого проекта",
        "Произошла катастрофа на сервере",
        "Этот код работает без проблем",
        "Удача"
    )

    testPhrases.forEach { phrase ->
        println("Оригинал: $phrase")
        println("Результат: ${makeIronic(phrase)}")
        println("---")

        val email = "username@example.com"
        val obfuscated = convertEmailToObfuscated(email)
        println("Оригинал: $email")
        println("Преобразованный: $obfuscated")

        val phrase1 = "Котлин лучший язык программирования"
        val phrase2 = "Объектно Ориентированное Программирование"
        val phrase3 = "Альфа Банк предоставляет услуги"

        println("Фраза: $phrase1 → Аббревиатура: ${createAbbreviation(phrase1)}")
        println("Фраза: $phrase2 → Аббревиатура: ${createAbbreviation(phrase2)}")
        println("Фраза: $phrase3 → Аббревиатура: ${createAbbreviation(phrase3)}")
    }
}

fun makeIronic(text: String): String {
    var result = text.trim()

    // Проверка: если фраза содержит только одно слово
    if (result.split("\\s+".toRegex()).size == 1) {
        return "Иногда, $result, но не всегда"
    }

    // Проверка: если фраза содержит "невозможно"
    if ("невозможно" in result) {
        result = result.replace("невозможно", "совершенно точно возможно, просто требует времени")
    }

    // Проверка: если фраза начинается с "Я не уверен"
    if (result.startsWith("Я не уверен", ignoreCase = true)) {
        result = "$result, но моя интуиция говорит об обратном"
    }

    // Проверка: если фраза содержит "катастрофа"
    if ("катастрофа" in result) {
        result = result.replace("катастрофа", "интересное событие")
    }

    // Проверка: если фраза заканчивается на "без проблем"
    if (result.endsWith("без проблем", ignoreCase = true)) {
        result = result.replace("без проблем", "с парой интересных вызовов на пути")
    }

    return result
}

fun extractDateTimeWithIndexOf(log: String) {
    val separator = "->"
    val index = log.indexOf(separator)

    if (index == -1) {
        println("Ошибка: строка лога не содержит разделитель '$separator'")
        return
    }

    // Извлекаем правую часть после "->"
    val dateTimeStr = log.substring(index + separator.length).trim()

    // Разделяем дату и время
    val spaceIndex = dateTimeStr.indexOf(' ')
    if (spaceIndex == -1 || spaceIndex == 0 || spaceIndex == dateTimeStr.length - 1) {
        println("Ошибка: неверный формат даты и времени")
        return
    }

    val date = dateTimeStr.substring(0, spaceIndex)
    val time = dateTimeStr.substring(spaceIndex + 1)

    // Выводим результат
    println("Дата: $date")
    println("Время: $time")
}

fun maskCreditCardNumberWithStructure(cardNumber: String): String {
    val digitsOnly = cardNumber.replace(" ", "")

    if (digitsOnly.length < 4) {
        return "Некорректный номер карты"
    }

    val lastFour = digitsOnly.takeLast(4)
    val maskedCount = digitsOnly.length - 4
    val maskedPart = "*".repeat(maskedCount)

    val masked = maskedPart + lastFour
    return masked.chunked(4).joinToString(" ")
}

fun convertEmailToObfuscated(email: String): String {
    return email
        .replace("@", " [at] ")
        .replace(".", " [dot] ")
}

fun extractFileNameBySplit(filePath: String): String {
    return filePath
        .split('/', '\\')  // Разделяем по обоим типам слешей
        .last()            // Берем последнюю часть
        .trim()
}

fun createAbbreviation(phrase: String): String {
    // Разделяем строку на слова по пробелам
    val words = phrase.split(" ")

    // Переменная для накопления первых букв
    var abbreviation = ""

    // Перебираем каждое слово
    for (word in words) {
        // Проверяем, что слово не пустое
        if (word.isNotEmpty()) {
            // Добавляем первую букву слова (в верхнем регистре)
            abbreviation += word[0].uppercase()
        }
    }

    return abbreviation
}
