package ru.stim.one.lesson15.homework

// Базовый абстрактный класс
abstract class EducationalInstitution(
    open val name: String,
    open val address: String
) {
    abstract fun getStudentCount(): Int
    abstract fun getLevel(): String
}

// Производные: Школа, Колледж, Университет
class School(
    override val name: String,
    override val address: String,
    private val gradeLevels: IntRange,
    private val studentCount: Int
) : EducationalInstitution(name, address) {
    override fun getStudentCount(): Int = studentCount
    override fun getLevel(): String = "Среднее образование"
}

class College(
    override val name: String,
    override val address: String,
    private val programs: List<String>,
    private val studentCount: Int
) : EducationalInstitution(name, address) {
    override fun getStudentCount(): Int = studentCount
    override fun getLevel(): String = "Среднее профессиональное"
}

class University(
    override val name: String,
    override val address: String,
    private val faculties: List<String>,
    private val studentCount: Int
) : EducationalInstitution(name, address) {
    override fun getStudentCount(): Int = studentCount
    override fun getLevel(): String = "Высшее образование"
}