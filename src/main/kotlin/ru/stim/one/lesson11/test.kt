package ru.stim.one.lesson11

fun main(){

    fun f1 (a: String){

    }

    fun f2 (a: Double, b:Double): Double {
    return a
    }

    fun f3 (a: String?): Boolean {
    return true
    }

    fun f4 (a: Int, b: Int): Int {
    return a + b
    }

    fun f5 (a: Int, b: Int): Int {
    return if (a > b) {
         a
    } else b
    }

//    fun f6 (a: List<Int>) {
//        for (b in a) {
//            if (b > 0)
//                println(b)
//            } else if (b == 0) {
//                println("end")
//            } else return
//        }
}

    fun f7 (a: MutableList<String>, b: String) {
        for (i in a.indices) {
            if(a[i].contains(b))
                a[i] = a[i].replace(b, b.uppercase())
            return
        }
    }