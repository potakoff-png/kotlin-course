package ru.stim.one.lesson12

fun main() {

    val hex = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val hex1 = hex.getOrElse(80) {5}

    val hex2 = hex.joinToString (separator = " % ")

    val hex3 = hex.sum()

    val hex4 = hex.firstOrNull() { it < 0}

    val hex5 = hex.contains(6)

    val hex6 = hex.filter {it in 18..30}

    val hex7 = hex.filterNotNull ()

    val hex8 = listOf("Solnce", "More")

    val hex9 = hex8.map {it.length}

    val hex10 = hex8.associateWith {it.reversed()}

    val hex11 = hex8.sorted()

    println(hex.forEach { it * it })

    val hex12 = listOf("Solnce1", "More1")

    val hex13 = hex8.groupBy { it.last() }

    println(hex13)


}