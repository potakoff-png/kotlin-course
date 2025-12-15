package ru.stim.one.lesson26.homework

import java.io.File

fun main() {
    val workspace = File("workspace")

    // === Задача 1: Создать файл и проверить существование (без переменной) ===
    println("=== Задача 1 ===")
    File("workspace/task1/example.txt")
        .apply { parentFile.mkdirs() }
        .also { it.writeText("Hello, Kotlin!") }
        .let { file -> println("Файл существует: ${file.exists()}") }

    // === Задача 2: Создать директорию и вывести абсолютный путь ===
    println("\n=== Задача 2 ===")
    File("workspace/task2/testDir")
        .apply { mkdirs() }
        .also { dir ->
            println("Это директория: ${dir.isDirectory}")
            println("Абсолютный путь: ${dir.absolutePath}")
        }

    // === Задача 3: Создать структуру поддиректорий и проверить содержимое ===
    println("\n=== Задача 3 ===")
    File("workspace/task3/structure")
        .apply { mkdirs() }
        .resolve("myDir")
        .apply {
            resolve("subDir1").mkdirs()
            resolve("subDir2").mkdirs()
        }
        .also { myDir ->
            val subDirs = myDir.listFiles { file -> file.isDirectory }?.map { it.name } ?: emptyList()
            println("Поддиректории myDir: $subDirs")
            println("Содержит subDir1 и subDir2: ${subDirs.containsAll(listOf("subDir1", "subDir2"))}")
        }

    // === Задача 4: Создать и удалить директорию со всем содержимым ===
    println("\n=== Задача 4 ===")
    File("workspace/task4/temp")
        .apply {
            resolve("subdir/file.txt").parentFile.mkdirs()
            resolve("subdir/file.txt").writeText("temp")
            resolve("data.bin").writeBytes(byteArrayOf(1, 2, 3))
        }
        .parentFile // возвращаем temp
        .also { println("До удаления: ${it.exists()}") }
        .deleteRecursively()
        .also { deleted ->
            println("Удалено файлов/директорий: $deleted")
            println("После удаления: ${File("workspace/task4").exists()}")
        }

    // === Задача 5: Записать и прочитать config.txt, вывести только значения ===
    println("\n=== Задача 5 ===")
    File("workspace/task5/config/config.txt")
        .apply { parentFile.mkdirs() }
        .also { config ->
            config.writeText("""
                host=localhost
                port=8080
                debug=true
                timeout=30
            """.trimIndent())
        }
        .readLines()
        .mapNotNull { line ->
            if (line.contains("=")) line.substringAfter("=") else null
        }
        .also { values -> println("Значения: $values") }

    // === Задача 6: Рекурсивный обход workspace — сначала директории, потом файлы ===
    println("\n=== Задача 6 ===")
    val root = File("workspace")
    if (root.exists() && root.isDirectory) {
        val (dirs, files) = root.walk().toList().partition { it.isDirectory }

        println("=== Директории ===")
        dirs.forEach { println("D: ${it.absolutePath}") }

        println("=== Файлы ===")
        files.forEach { println("F: ${it.absolutePath}") }
    }

    // === Задача 7: Создать readme.md, если его нет, и проверить содержимое ===
    println("\n=== Задача 7 ===")
    File("workspace/task7/docs")
        .apply { mkdirs() }
        .resolve("readme.md")
        .also { readme ->
            if (!readme.exists()) {
                readme.writeText("This is a README file.")
                println("Файл readme.md создан.")
            } else {
                println("Файл readme.md уже существует.")
            }
        }
        .also { readme ->
            val content = readme.readText().trim()
            println("Содержимое: '$content'")
        }

    // === Задача 8: Создать файлы и скопировать с сохранением структуры ===
    println("\n=== Задача 8 ===")
    val dataDir = File("workspace/task8/data")
    val backupDir = File("workspace/task8/backup")

    // Создаём файлы
    listOf(
        "1/4/prod/data14.mysql",
        "2/3/prod/data23.mysql",
        "5/2/prod/data52.mysql"
    ).forEach { path ->
        dataDir.resolve(path)
            .apply { parentFile.mkdirs() }
            .writeText("Data for $path")
    }

    // Копируем с сохранением структуры
    backupDir.mkdirs()

    dataDir.walk()
        .filter { it.isFile }
        .forEach { file ->
            val relativePath = file.relativeTo(dataDir)
            val targetFile = backupDir.resolve(relativePath)
            targetFile.parentFile.mkdirs()
            file.copyTo(targetFile, overwrite = true)
            println("Скопировано: $relativePath")
        }

    // Проверка копирования
    backupDir.walk()
        .filter { it.isFile }
        .forEach { println("В бэкапе: ${it.relativeTo(backupDir)}") }
}