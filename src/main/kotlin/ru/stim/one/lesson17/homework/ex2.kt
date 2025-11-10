package ru.stim.one.lesson17.homework

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    private val privateVal: String,
    // 2. объясни, почему это поле недоступно в main()
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }

    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    var privateField = "6. добавь сеттер чтобы изменить меня из main()"
        set // Добавлен сеттер, чтобы разрешить изменение через reflection или косвенно (но не напрямую)
            (value) {
            field = value
        }

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // 7. объясни, почему эта функция не может быть публичной
    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. объясни, почему эта функция не может быть публичной или protected
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass()

    private class PrivateClass()
}

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    publicVal: String
) : BaseClass(privateVal, protectedVal, privateVal) {

    // Добавим свойство, чтобы обойти ограничение verifyPublicField
    // Проблема: verifyPublicField(value) требует длины < 3, но "Антонио Бандерас" — длинное имя
    // Решение: переопределить verifyPublicField, чтобы разрешить любые строки
    override fun verifyPublicField(value: String): Boolean {
        return true // 4. Обход проверки, чтобы можно было установить длинное имя
    }

    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // Ответ: getAll() — публичная функция в родительском классе, и она наследуется автоматически.
    // Все public и protected члены родителя доступны в наследнике, если не скрыты.

    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределения метода privatePrint()
    // Ответ: будет напечатано "Печать из класса BaseClass", потому что private функции
    // НЕ УЧАСТВУЮТ в полиморфизме. privatePrint() в ChildrenClass — это отдельная функция,
    // она не переопределяет родительскую, а просто скрывает её в своём классе.
    // Вызов идёт через printText(), который находится в BaseClass и вызывает свой private метод.

    // Добавим открытый сеттер для protectedField, чтобы можно было изменить его из main()
    //fun setProtectedField(value: String) {
    //    protectedField = value
    //}

    // Добавим функцию для изменения privateField через косвенный способ
    // (прямого доступа нет, но можно добавить метод в ChildrenClass)
    //fun setPrivateField(value: String) {
        // privateField доступен здесь, потому что мы в наследнике BaseClass
        // и private члены родителя видны в наследнике (но не за его пределами)
    //    privateField = value
    //}
}