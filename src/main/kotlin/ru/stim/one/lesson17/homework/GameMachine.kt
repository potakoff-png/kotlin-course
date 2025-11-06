package ru.stim.one.lesson17.homework

class GameMachine(
    val color: String,
    val model: String,
    val owner: String,
    val supportPhone: String,
    val sessionCost: Double,
    private val pinCode: String // приватно — не должен быть доступен снаружи
) {
    private var poweredOn = false // автомат выключен по умолчанию
    private var osLoaded = false // ОС не загружена
    private var sessionPaid = false // игровой сеанс не оплачен
    private var balance: Double = 0.0 // выручка, накапливается со временем
    private val installedGames: MutableList<String> = mutableListOf() // можно изменять
    private var joystickPresent: Boolean = true // по умолчанию джойстик есть

    // === Методы ===

    /**
     * Включает автомат.
     * @return true, если включение прошло успешно
     */
    fun powerOn(): Boolean {
        if (poweredOn) {
            println("Автомат уже включён.")
            return false
        }
        poweredOn = true
        println("Автомат включён.")
        return true
    }

    /**
     * Выключает автомат.
     * @return true, если выключение прошло успешно
     */
    fun powerOff(): Boolean {
        if (!poweredOn) {
            println("Автомат уже выключен.")
            return false
        }
        if (osLoaded) {
            shutdownOS()
        }
        poweredOn = false
        sessionPaid = false
        println("Автомат выключен.")
        return true
    }

    /**
     * Загружает операционную систему.
     * Доступно только если автомат включён.
     * @return true, если загрузка прошла успешно
     */
    fun loadOS(): Boolean {
        if (!poweredOn) {
            println("Нельзя загрузить ОС: автомат выключен.")
            return false
        }
        if (osLoaded) {
            println("ОС уже загружена.")
            return false
        }
        osLoaded = true
        println("ОС загружена.")
        return true
    }

    /**
     * Завершает работу ОС.
     * @return true, если ОС успешно завершена
     */
    fun shutdownOS(): Boolean {
        if (!osLoaded) {
            println("ОС не была загружена.")
            return false
        }
        osLoaded = false
        sessionPaid = false
        println("Работа ОС завершена.")
        return true
    }

    /**
     * Показывает список установленных игр.
     * Доступно только если ОС загружена.
     */
    fun showGameList() {
        if (!osLoaded) {
            println("Невозможно показать игры: ОС не загружена.")
            return
        }
        if (installedGames.isEmpty()) {
            println("Нет установленных игр.")
            return
        }
        println("Доступные игры: ${installedGames.joinToString(", ")}")
    }

    /**
     * Запускает игру по названию.
     * @param gameName название игры
     * @return true, если игра запущена
     */
    fun startGame(gameName: String): Boolean {
        if (!osLoaded) {
            println("Невозможно запустить игру: ОС не загружена.")
            return false
        }
        if (!sessionPaid) {
            println("Невозможно запустить игру: игровой сеанс не оплачен.")
            return false
        }
        if (!installedGames.contains(gameName)) {
            println("Игра '$gameName' не установлена.")
            return false
        }
        println("Запуск игры: $gameName...")
        return true
    }

    /**
     * Оплачивает игровой сеанс.
     * @param amount сумма оплаты
     * @return true, если оплата прошла успешно
     */
    fun payForSession(amount: Double): Boolean {
        if (!osLoaded) {
            println("Невозможно оплатить: ОС не загружена.")
            return false
        }
        if (amount < sessionCost) {
            println("Недостаточно средств. Требуется: $sessionCost, внесено: $amount")
            return false
        }
        sessionPaid = true
        balance += sessionCost
        println("Игровой сеанс оплачен. Доступно: $sessionCost мин.")
        return true
    }

    /**
     * Добавляет игру в список установленных.
     * @param gameName название игры
     * @return true, если игра установлена
     */
    fun installGame(gameName: String): Boolean {
        if (installedGames.contains(gameName)) {
            println("Игра '$gameName' уже установлена.")
            return false
        }
        installedGames.add(gameName)
        println("Игра '$gameName' установлена.")
        return true
    }

    /**
     * Удаляет игру из списка.
     * @param gameName название игры
     * @return true, если игра удалена
     */
    fun uninstallGame(gameName: String): Boolean {
        if (!installedGames.remove(gameName)) {
            println("Игра '$gameName' не найдена.")
            return false
        }
        println("Игра '$gameName' удалена.")
        return true
    }

    /**
     * Снимает наличные с помощью пин-кода.
     * @param pin введённый пин-код
     * @param amount запрашиваемая сумма
     * @return true, если выдача прошла успешно
     */
    fun withdrawCash(pin: String, amount: Double): Boolean {
        if (pin != pinCode) {
            println("Ошибка: неверный пин-код.")
            return false
        }
        if (amount > balance) {
            println("Ошибка: недостаточно средств в автомате. Доступно: $balance")
            return false
        }
        balance -= amount
        println("Выдано: $amount руб. Остаток в автомате: $balance")
        return true
    }

    /**
     * Открывает сейф и выдаёт весь остаток.
     * Используется владельцем для инкассации.
     * @param pin пин-код
     * @return сумма, выданная из сейфа, или 0 при ошибке
     */
    fun openSafeAndDispenseAll(pin: String): Double {
        if (pin != pinCode) {
            println("Доступ запрещён: неверный пин-код.")
            return 0.0
        }
        val amount = balance
        println("Сейф открыт. Выдано: $amount руб.")
        balance = 0.0
        return amount
    }

    // === Геттеры для безопасного доступа к состоянию ===

    /**
     * Возвращает текущий баланс автомата.
     */
    fun getBalance(): Double = balance

    /**
     * Проверяет, включён ли автомат.
     */
    fun isPoweredOn(): Boolean = poweredOn

    /**
     * Проверяет, загружена ли ОС.
     */
    fun isOSLoaded(): Boolean = osLoaded

    /**
     * Проверяет, оплачен ли игровой сеанс.
     */
    fun isSessionPaid(): Boolean = sessionPaid

    /**
     * Возвращает список установленных игр (неизменяемый).
     */
    fun getInstalledGames(): List<String> = installedGames.toList()

    /**
     * Проверяет наличие джойстика.
     */
    fun hasJoystick(): Boolean = joystickPresent

    /**
     * Устанавливает наличие джойстика.
     */
    fun setJoystickPresent(present: Boolean) {
        joystickPresent = present
        println("Наличие джойстика: $present")
    }
}