package ru.stim.one.lesson13.homework

//1. Среднее время выполнения теста

fun averageTestTime(testTimes: Map<String, Int>): Double {
    return testTimes.values.average()
}

//2. Вывести список всех тестовых методов

fun listTestMethods(metadata: Map<String, String>): List<String> {
    return metadata.keys.toList()
}

//3. Добавить новый тест в изменяемый словарь

fun addTestResult(mutableResults: MutableMap<String, String>, testName: String, result: String) {
    mutableResults[testName] = result
}

//4. Посчитать количество успешных тестов

fun countPassedTests(results: Map<String, String>): Int {
    return results.count { it.value == "passed" }
}

//5. Удалить запись о баге

fun removeFixedBug(mutableBugs: MutableMap<String, String>, bugName: String) {
    mutableBugs.remove(bugName)
}

//6. Вывести сообщение о странице и статусе

fun printPageStatus(pageStatuses: Map<String, Int>) {
    pageStatuses.forEach { (url, status) ->
        println("Страница: $url, Статус: $status")
    }
}

//7. Найти сервисы с временем ответа выше порога

fun findSlowServices(services: Map<String, Long>, threshold: Long): Map<String, Long> {
    return services.filter { it.value > threshold }
}

//8. Найти статус endpoint или вернуть "not tested"

fun getEndpointStatus(apiResults: Map<String, String>, endpoint: String): String {
    return apiResults.getOrDefault(endpoint, "not tested")
}

//9. Получить значение "browserType", не null

fun getBrowserType(config: Map<String, String>): String {
    return config.getValue("browserType") // бросит исключение, если ключа нет
}

//10. Создать копию словаря с новой версией

fun addNewVersion(versions: Map<String, String>, newId: String, status: String): Map<String, String> {
    return versions + (newId to status)
}

//11. Получить настройки устройства или по умолчанию

fun getDeviceSettings(deviceSettings: Map<String, String>, model: String): String {
    return deviceSettings.getOrElse(model) { "default settings" }
}

//12. Проверить наличие кода ошибки

fun hasErrorCode(errors: Map<Int, String>, errorCode: Int): Boolean {
    return errors.containsKey(errorCode)
}

//13. Отфильтровать тесты по версии в ключе

fun filterTestsByVersion(tests: Map<String, String>, version: String): Map<String, String> {
    return tests.filterKeys { it.contains(version) }
}

//14. Проверить, есть ли модули с неудачным тестированием

fun hasFailedModules(moduleResults: Map<String, String>): Boolean {
    return moduleResults.any { it.value == "failed" }
}

//15. Добавить настройки из другого словаря

fun mergeTestConfigurations(target: MutableMap<String, String>, source: Map<String, String>) {
    target.putAll(source)
}

//16. Объединить два словаря с багами

fun mergeBugReports(bugs1: Map<String, String>, bugs2: Map<String, String>): Map<String, String> {
    return bugs1 + bugs2
}

//17. Очистить словарь с временными данными

fun clearTemporaryData(mutableTempData: MutableMap<String, Any>) {
    mutableTempData.clear()
}

//18. Исключить пропущенные тесты из отчёта

fun excludeSkippedTests(testResults: Map<String, String>): Map<String, String> {
    return testResults - testResults.filterValues { it == "skipped" }.keys
}

//19. Создать копию без нескольких конфигураций

fun removeConfigs(configs: Map<String, String>, toRemove: List<String>): Map<String, String> {
    return configs - toRemove
}

//20. Создать отчёт в виде списка строк

fun generateTestReport(testResults: Map<String, String>): List<String> {
    return testResults.map { "Test ID: ${it.key}, результат: ${it.value}" }
}

//21. Преобразовать изменяемый словарь в неизменяемый

fun archiveTestResults(mutableResults: MutableMap<String, String>): Map<String, String> {
    return mutableResults.toMap()
}

//22. Заменить числовой ID на строковый

fun convertIdToString(testTimes: Map<Int, Long>): Map<String, Long> {
    return testTimes.mapKeys { it.key.toString() }
}

//23. Увеличить каждую оценку на 10%

fun increasePerformanceScores(scores: Map<String, Double>): Map<String, Double> {
    return scores.mapValues { it.value * 1.1 }
}

//24. Проверить, пуст ли словарь с ошибками

fun areCompilationErrorsEmpty(errors: Map<String, String>): Boolean {
    return errors.isEmpty()
}

//25. Убедиться, что словарь с нагрузочным тестированием не пуст

fun isLoadTestResultsNotEmpty(loadResults: Map<String, Int>): Boolean {
    return loadResults.isNotEmpty()
}

//26. Проверить, прошли ли все тесты успешно

fun areAllTestsPassed(results: Map<String, String>): Boolean {
    return results.all { it.value == "passed" }
}

//27. Определить, есть ли хотя бы одна ошибка

fun hasAnyTestError(results: Map<String, String>): Boolean {
    return results.any { it.value == "failed" }
}

//28. Отфильтровать неуспешные тесты с "optional" в названии

fun filterOptionalFailedTests(results: Map<String, String>): Map<String, String> {
    return results.filterKeys { it.contains("optional") }
        .filterValues { it == "failed" }
}