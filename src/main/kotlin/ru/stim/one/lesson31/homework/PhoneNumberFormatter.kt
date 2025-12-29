package ru.stim.one.lesson31.homework

class PhoneNumberFormatter {

    /**
     * Форматирует входную строку в стандартный формат российского номера: +7 (XXX) XXX-XX-XX
     * @param input входной номер телефона
     * @return отформатированный номер
     * @throws IllegalArgumentException если номер некорректен
     */
    fun formatPhoneNumber(input: String): String {
        require(input.isNotBlank()) { "Номер телефона не может быть пустым" }

        // Удаляем все нецифровые символы
        val digits = input.replace("\\D".toRegex(), "")

        // Должно быть 10 или 11 цифр
        if (digits.length !in setOf(10, 11)) {
            throw IllegalArgumentException("Некорректная длина номера: ${digits.length}")
        }

        val normalizedNumber = when {
            digits.length == 11 -> {
                if (digits[0] != '8' && digits[0] != '7') {
                    throw IllegalArgumentException("Номер из 11 цифр должен начинаться с 8 или 7")
                }
                digits.substring(1) // убираем первый символ
            }
            else -> digits // 10 цифр — уже без кода страны
        }

        // Форматируем: +7 (XXX) XXX-XX-XX
        val code = normalizedNumber.substring(0, 3)
        val part1 = normalizedNumber.substring(3, 6)
        val part2 = normalizedNumber.substring(6, 8)
        val part3 = normalizedNumber.substring(8, 10)

        return "+7 ($code) $part1-$part2-$part3"
    }
}