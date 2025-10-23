package ru.stim.one.lesson14.homework

// 5. Мероприятие: концерт
class Concert(
    private val band: String,
    private val venue: String,
    private val ticketPrice: Double,
    private val capacity: Int
) {
    private var soldTickets = 0

    fun concertInfo() {
        println(
            "Концерт: $band | Место: $venue | Билеты: $soldTickets/$capacity | Цена: $ticketPrice"
        )
    }

    fun buyTicket(): Boolean {
        if (soldTickets < capacity) {
            soldTickets++
            println("Билет куплен! Продано: $soldTickets")
            return true
        } else {
            println("Все билеты проданы!")
            return false
        }
    }
}
