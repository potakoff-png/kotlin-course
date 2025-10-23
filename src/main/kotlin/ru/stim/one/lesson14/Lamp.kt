package ru.stim.one.lesson14

class Lamp (var shine: Boolean) {
    fun vkl () {
        shine = true
    }
    fun vikl () {
        shine = false
    }
    fun tgl () {
        shine = !shine
    }
}