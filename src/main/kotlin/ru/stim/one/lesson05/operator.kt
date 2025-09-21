package ru.stim.one.lesson05

fun main() {

    val sum = 10 + 5
    val diff = 10 - 5
    val prod = 10 * 5
    val quet = 10 / 5
    val rem = 10 % 5

    val isEq = (5 == 5)
    val isNotEq = (5 != 5)
    val isGreat = (15 >= 5)
    val isLess = (3 < 5)

    val andResult = (5 > 3) && (5 > 4)
    val orResult = (5 < 3) || (5 > 4)
    val notResult = !(5 > 3)

    var number = 5
    number += 3 //number теперь равно 8
    number = number + 3
    number -= 2
    number *= 4
    number /= 3

    val r = ++number //сначала вычисление, потом присваивание
    number++ //сначала присваивание, потом вычисление
    --number

    var a = 5
    var b = a++
    println("a: $a")
    println("b: $b")

    var c = 5
    var d = ++c
    println("c: $c")
    println("d: $d")
    val rr = 3 - 4 / 5

    val rrr = (true || false) && !true

    val name: String? = null
    val result = name ?: "Unknown" //"Unknown", так как нейм равен нулл
    println(result)

    (3 + 2 < 6) && (4 * 2 == 8)
    //true && true = true
    (10 - 5 >= 5) || (2 * 3 != 6)
    //true || false = true
    (8 / 2 == 4) && (7 % 3 != 1)
    //true && false = false
    (8 % 4 == 2) || (2 + 2 == 5)
    //false || false = false

    val userLang: String? = null
    val defaultLang = "English"
    val currentLang = userLang ?: defaultLang
    println(currentLang)

    val innerAccumulator: Int = 5000
    val externalAccumulator: Int? = 2000
    val powerBank = innerAccumulator + (externalAccumulator ?: 0)
    println(powerBank)

    val goodsInContainer: String? = null
    val checkedGoods = goodsInContainer ?: "Error"
    println(checkedGoods)

    val price = 80.0
    val discountInPercent: Double? = null
    val discount = (discountInPercent ?: 0.0) / 100.0
    val discountPrice = price - price * discount
    println(discountPrice)

}