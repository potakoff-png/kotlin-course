package ru.stim.one.lesson10

fun main(){
    val f = mapOf<String, Int>("a" to 1, "b" to 2, "c" to 3)
    val g = mutableMapOf<String, String>("car" to "wash")
    g["flighter"] = "fly"
    g["boat"] = "swim"
    g["velo"] = "road"
    g.remove(key = "velo")

    for ((k, v) in g) {
        println("$k -> $v")
    }

    test(g,"car")
    if ("boat" in g) {
        println(g["car"])
    } else {
        println("carer")
    }

    val calendar = mapOf<String, MutableList<String>>()
    val plan = mapOf<String, MutableMap<String, String>>()
    val telephon = mutableMapOf<String, MutableMap<Int, String>>()
    telephon["Yrka"] = mutableMapOf(112 to "Odinokiy")
    telephon["Yrka"]?.put(1136, "Odinok")

}

fun test(map: Map<String, String>, key: String) {
    for ((k, v) in map) {
        if (k == key) {
            println(v)
            return
        }
    }
    println("not found")
}