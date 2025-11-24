package ru.stim.one.lesson22.homework

class MyIndexException(message: String, cause: IndexOutOfBoundsException) : RuntimeException(message, cause)