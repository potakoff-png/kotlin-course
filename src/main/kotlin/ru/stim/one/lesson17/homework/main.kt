package ru.stim.one.lesson17.homework

fun main() {
    val machine = GameMachine(
        color = "Красный",
        model = "ArcadePro X1",
        owner = "ООО 'ИгроТех'",
        supportPhone = "+7 (495) 123-45-67",
        sessionCost = 100.0,
        pinCode = "1234"
    )

    machine.installGame("Pac-Man")
    machine.installGame("Space Invaders")

    machine.powerOn()
    machine.loadOS()
    machine.showGameList()

    machine.payForSession(100.0)
    machine.startGame("Pac-Man")

    machine.withdrawCash("1234", 50.0)
    println("Текущий баланс: ${machine.getBalance()}")

    machine.openSafeAndDispenseAll("1234")
    machine.powerOff()

        //ex2
        val child = ChildrenClass(
            privateVal = "Приватное значение",
            protectedVal = "Защищённое значение",
            publicVal = "Публичное значение"
        )

        // 1. Почему privateVal доступно в main()?
        // ОТВЕТ: НЕДОСТУПНО напрямую! ❌
        // ОШИБКА: privateVal — private в BaseClass, но в ChildrenClass объявлено как val privateVal — это ПУБЛИЧНОЕ СВОЙСТВО!
        // ВАЖНО: В ChildrenClass `val privateVal: String` — это НОВОЕ публичное свойство, не связанное с privateVal из родителя.
        // Поэтому оно доступно в main() — потому что объявлено как public val в ChildrenClass.

        println("1. privateVal из ChildrenClass: ${child.privateVal}") // ✅ Работает

        // 2. Почему protectedVal недоступно в main()?
        // ОТВЕТ: protected — доступен только в наследниках и пакете. В main() — вне класса — недоступен.
        // println(child.protectedVal) // ❌ Ошибка компиляции

        // 3. Изменить publicField на "Антонио Бандерас"
        child.publicField = "Антонио Бандерас" // ✅ Сработает благодаря override verifyPublicField
        println("\n--- getAll() после изменения publicField ---")
        println(child.getAll())

        // 5. Изменить protectedField
        child.setProtectedField("Я изменился через сеттер")
        println("\n--- После изменения protectedField ---")
        println(child.getAll())

        // 6. Изменить privateField
        child.setPrivateField("Я тоже изменился!")
        println("\n--- После изменения privateField ---")
        println(child.getAll())

        // 8. Почему в "generate" другой текст?
        // ОТВЕТ: Потому что метод generate() был переопределён в ChildrenClass.
        // В BaseClass он возвращает "Это генерация из родительского класса",
        // а в ChildrenClass — "Это генерация из дочернего класса".
        // Это пример полиморфизма: вызывается переопределённая версия.

        // 12. Что выведет printText()?
        println("\n--- Вызов printText() ---")
        child.printText() // Выведет: "Печать из класса BaseClass"
        // Потому что private функции не переопределяются — это разные функции.

        // 10. Почему publicVal доступен в main(), несмотря на то, что это не поле?
        // ОТВЕТ: Это НЕ так. publicVal — это параметр конструктора ChildrenClass, но он НЕ сохраняется как свойство.
        // Чтобы было свойство, нужно писать `val publicVal: String`.
        // Сейчас publicVal используется только для передачи в супер-конструктор.
        // Поэтому в main() нельзя написать `child.publicVal` — будет ошибка.
        // Это ловушка: publicVal — не свойство, а просто параметр.

}