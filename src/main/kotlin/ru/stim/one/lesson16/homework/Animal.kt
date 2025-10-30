package ru.stim.one.lesson16.homework

// Базовый класс
open class Animal {
    open fun makeSound() {
        println("This animal makes no sound.")
    }
}

class Dog : Animal() {
    override fun makeSound() {
        println("\u001b[32mBark\u001b[0m") // Зелёный
    }
}

class Cat : Animal() {
    override fun makeSound() {
        println("\u001b[36mMeow\u001b[0m") // Бирюзовый
    }
}

class Bird : Animal() {
    override fun makeSound() {
        println("\u001b[33mTweet\u001b[0m") // Жёлтый
    }
}