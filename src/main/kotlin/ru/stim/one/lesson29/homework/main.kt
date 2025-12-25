package ru.stim.one.lesson29.homework

//import org.gradle.internal.impldep.com.google.gson.Gson
//import org.gradle.internal.impldep.com.google.gson.GsonBuilder
import java.io.File

//Задание 2
val frontendTeamLead = Employee(
    name = "Alice",
    isEmployed = true,
    birthDate = "1990-03-12",
    position = CharacterTypes.TEAM_LEAD,
    subordinates = listOf(
        Employee(
            name = "Bob",
            isEmployed = true,
            birthDate = "1995-06-21",
            position = CharacterTypes.UX_UI
        ),
        Employee(
            name = "Charlie",
            isEmployed = true,
            birthDate = "1993-11-02",
            position = CharacterTypes.FRONTEND_DEV
        ),
        Employee(
            name = "Diana",
            isEmployed = true,
            birthDate = "1996-01-17",
            position = CharacterTypes.QA
        )
    )
)
val backendTeamLead = Employee(
    name = "Ethan",
    isEmployed = true,
    birthDate = "1988-09-08",
    position = CharacterTypes.TEAM_LEAD,
    subordinates = listOf(
        Employee(
            name = "Frank",
            isEmployed = true,
            birthDate = "1992-04-30",
            position = CharacterTypes.BACKEND_DEV
        ),
        Employee(
            name = "Grace",
            isEmployed = true,
            birthDate = "1994-07-14",
            position = CharacterTypes.BACKEND_DEV
        ),
        Employee(
            name = "Helen",
            isEmployed = true,
            birthDate = "1991-12-05",
            position = CharacterTypes.QA
        ),
        Employee(
            name = "Ivan",
            isEmployed = true,
            birthDate = "1989-02-19",
            position = CharacterTypes.SYSADMIN
        )
    )
)
val pm = Employee(
    name = "Michael",
    isEmployed = true,
    birthDate = "1987-05-10",
    position = CharacterTypes.PM,
    subordinates = listOf(frontendTeamLead, backendTeamLead)
)
val crm = Employee(
    name = "Sophia",
    isEmployed = true,
    birthDate = "1991-08-23",
    position = CharacterTypes.CRM
)
val cto = Employee(
    name = "Oliver",
    isEmployed = true,
    birthDate = "1985-01-01",
    position = CharacterTypes.CTO,
    subordinates = listOf(pm, crm)
)

//Задание 3

//fun ex3() {
//    val gson = GsonBuilder().setPrettyPrinting().create()
//    gson.toJson(cto).also {
//        File("structure.json").writeText(it)
//    }
//}

//Задание 4

//fun ex4() {
//    val gson = Gson()
//    val json = File("structure.json").readText()
//    val cto = gson.fromJson(json, Employee::class.java)
//    println(cto)

// Задание 5
//    ex5(cto).groupBy { it.position }
//        .map { group -> "${group.key}: ${group.value.joinToString { it.name }}" }
//        .forEach { println(it) }
//}

//Задание 5

fun ex5(arg: Employee): List<Employee> {
    return if (arg.subordinates.isNotEmpty()) {
        arg.subordinates
            .flatMap {
                ex5(it)
            } + arg.copy(subordinates = emptyList())
    } else {
        listOf(arg)
    }
}