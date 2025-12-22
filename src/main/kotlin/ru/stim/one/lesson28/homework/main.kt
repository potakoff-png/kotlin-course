package ru.stim.one.lesson28.homework

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal

val now = Instant.now()
//println("Текущая метка времени (Instant): $now")

val birthDate = LocalDate.of(1990, 5, 15) // Пример: 15 мая 1990
//println("Дата рождения: $birthDate")

val today = LocalDate.now()
val period = Period.between(birthDate, today)
//println("Полных лет: ${period.years}")

fun formatTemporalCustom(temporal: Temporal): String {
    return when (temporal) {
        is LocalDateTime -> {
            val dt = temporal as LocalDateTime
            "${dt.toLocalDate()} ${dt.hour}:${dt.minute}:${dt.second} ${ZoneId.systemDefault()}"
        }
        is LocalDate -> {
            temporal.toString()
        }
        is LocalTime -> {
            "${temporal.hour}:${temporal.minute}:${temporal.second}"
        }
        is ZonedDateTime -> {
            val zdt = temporal as ZonedDateTime
            "${zdt.toLocalDate()} ${zdt.hour}:${zdt.minute}:${zdt.second} ${zdt.zone}"
        }
        is OffsetDateTime -> {
            val odt = temporal as OffsetDateTime
            "${odt.toLocalDate()} ${odt.hour}:${odt.minute}:${odt.second} ${odt.offset}"
        }
        is Instant -> {
            val zdt = temporal.atZone(ZoneId.systemDefault())
            "${zdt.toLocalDate()} ${zdt.hour}:${zdt.minute}:${zdt.second} ${zdt.zone}"
        }
        else -> temporal.toString()
    }
}

//println("\n=== Форматирование различных типов Temporal ===")

val localDateTime = LocalDateTime.of(2023, 10, 5, 14, 30, 45)
val localDate = LocalDate.of(2023, 10, 5)
val localTime = LocalTime.of(14, 30, 45)
val zonedDateTime = ZonedDateTime.of(2023, 10, 5, 14, 30, 45, 0, ZoneId.of("Europe/Moscow"))
val offsetDateTime = OffsetDateTime.of(2023, 10, 5, 14, 30, 45, 0, ZoneOffset.ofHours(3))
val instant = Instant.parse("2023-10-05T11:30:45Z")

//println("LocalDateTime (custom): ${formatTemporalCustom(localDateTime)}")
//println("LocalDateTime (ISO): ${formatTemporalISO(localDateTime)}")

//println("LocalDate (custom): ${formatTemporalCustom(localDate)}")
//println("LocalDate (ISO): ${formatTemporalISO(localDate)}")

//println("LocalTime (custom): ${formatTemporalCustom(localTime)}")
//println("LocalTime (ISO): ${formatTemporalISO(localTime)}")

//println("ZonedDateTime (custom): ${formatTemporalCustom(zonedDateTime)}")
//println("ZonedDateTime (ISO): ${formatTemporalISO(zonedDateTime)}")

//println("OffsetDateTime (custom): ${formatTemporalCustom(offsetDateTime)}")
//println("OffsetDateTime (ISO): ${formatTemporalISO(offsetDateTime)}")

//println("Instant (custom): ${formatTemporalCustom(instant)}")
//println("Instant (ISO): ${formatTemporalISO(instant)}")

private val BOOMER_START = LocalDate.of(1946, 1, 1)
private val BOOMER_END = LocalDate.of(1964, 12, 31)
private val ZOOMER_START = LocalDate.of(1997, 1, 1)
private val ZOOMER_END = LocalDate.of(2012, 12, 31)

fun LocalDate.identifyGeneration() {
    when {
        this in BOOMER_START..BOOMER_END -> println("Бумер")
        this in ZOOMER_START..ZOOMER_END -> println("Зумер")
        else -> println("Не определено")
    }
}

//println("\n=== Форматтер и арифметика дат ===")

val date1 = LocalDate.of(2023, 2, 25)
val date2 = LocalDate.of(2024, 2, 25)

val formatter = DateTimeFormatter.ofPattern("d MMMM") // Например: "25 февраля"

// Прибавляем 10 дней и форматируем
//println("Дата 1 + 10 дней: ${date1.plusDays(10).format(formatter)}")
//println("Дата 2 + 10 дней: ${date2.plusDays(10).format(formatter)}")

fun main() {
    println("=== 1. Текущее время ===")
    val now = Instant.now()
    println("Текущая метка времени (Instant): $now")

    println("\n=== 2. Дата рождения ===")
    val birthDate = LocalDate.of(1990, 5, 15)
    println("Дата рождения: $birthDate")

    println("\n=== 3. Возраст в годах ===")
    val today = LocalDate.now()
    val period = Period.between(birthDate, today)
    println("Полных лет: ${period.years}")

    println("\n=== 4-5. Форматирование Temporal ===")
    // ... (вставка объектов и вызов formatTemporalCustom / formatTemporalISO)

    println("\n=== 6. Определение поколения ===")
    LocalDate.of(1955, 6, 10).identifyGeneration()
    LocalDate.of(2005, 3, 22).identifyGeneration()
    LocalDate.of(1985, 7, 17).identifyGeneration()

    println("\n=== 7. Форматтер и арифметика ===")
    val date1 = LocalDate.of(2023, 2, 25)
    val date2 = LocalDate.of(2024, 2, 25)
    val formatter = DateTimeFormatter.ofPattern("d MMMM")

    println("2023-02-25 + 10 дней: ${date1.plusDays(10).format(formatter)}") // 7 марта
    println("2024-02-25 + 10 дней: ${date2.plusDays(10).format(formatter)}") // 6 марта
}