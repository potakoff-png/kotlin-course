package ru.stim.one.lesson03.homework

//1. Название нероприятия
val eventname: String = "Hackathon"
//2. Дата проведения
var date: String = "11.11.2025"
//3. Место проведения
var adress: String = "Moscow, Lenina street, 35"
//4. Подробный боджет мероприятия, включая расходы на оборудование, кейтеринг и другив операционные расходы,
private var moneydetails: Double = 34574359.65
//5. Количество участников
var members: Int = 32
//6. Длительность хакатона
var length: Int = 180
//7. Контактная информация и условия соглашений с поставщикани пищи, оборудования и других услут.
private val contactInfoAnoDeal: String = "Contact info and Document with all nain points"
//8. Текушее состояние ханатона (статус)
var eventStatus: String = "Not started"
//9. Список спонсоров
val sponsorslist: String = "Adidas, Intel"
//10. Бюджет нероприятия
private val money: Double = 94574359.65
//11. Текущий уровень доступа к интерниту
var ping: String = "high"
//12. Информация в транспортировке оборудования, распределении ресурсов и координации между различными конандами поддержки:
private val info: String = "Logistic info"
//13. Количество команд
var atylfleans: Int = 16
//14.Перечень задач
val joblist: String = "job list"
//15: План эвакуации
val exit: String = "plan"
//16. Список доступного оборудования (всё, что выделено для использования на мероприятий)
val equipmentlist: String = "equipment List"
//17. Список свободного оборудования
private val antist: String = "free equipment List"
//18. График питания участников (зависит от поставщика питания, определяемого за неделю до начала)
var eatingPlan: String = "eating plan"
//19. План мероприятий случай сбоев
val emergencyPlan: String = "emergency plan"
//20. Список экспертов и жюри
var expertlist: String = "experts list"
//21. Политика конфиденциальности
val privacyPolicy: String = "NDA"
//22. Приватные отзывы (фидбэк) участников и зрителей для анализа проблем.
private lateinit var feedback: String
//23. Текущая температура в помещении
var currentTemperature: Int = 22
//24. Данные мониторинга и анализ производительности сетевого оборудования и интернет-соединения для целей отладки своих прилож
var monitoringValuesAndPenfouanceAnalysis: String = "monitoring values and perfomance analysis"
//25. Регулятор скорости интернета
val SpeedRenulation: String = "internet speed regulation"
//26. Уровень освещения
var lightLevel: Int = 100
//27. Лог событий мероприятия
lateinit var eventLog: String
//28. Возможность получения медицинской помощи прямо на мероприятии (да/нет)
val medicHelp: Boolean = true
//29. Планы и процедуры для обеспечения безопасности мероприятия, включая планы эвакуации и протоколы чрезвычайных ситуаций.
val savePlan: String = "save plan"
//30. Регистрационный номер мероприятия
val eventRegisteredNumber: Int = 1236543
//31. Максимально допустимый уровень шума в помещении хакатона.
val maxNoiseLevel: Int = 80
//32. Индикатор превышения уровня шума в помещениях (превышен или не превышен в данный момент)
var noisendicator: Boolean = true
//33. План взаимодействия с прессой
val pressPlan: String = "press plan"
//34. Детальная публичная информация о проектах каждой команды, сбор данных включает в себя компиляцию кода и сбор статистики
lateinit var projectsDescription: String
//35. Статус получения всех необходимых разрешений для проведения
var status: Boolean = false
//36. Индикатор доступности специализированного оборудования в данный момент (например, специальному оборудованию)
var isSpecialEquipmentAvailable: Boolean = false
//37. Список партнеров мероприятия
var partners: String = "partners"
//38. Отчет, включающий фотографии, видео и отзывы, генерируется и становится доступен после завершения мероприятия.
val report: String by lazy {
        ""
    }
//39. Внутренние правила распределения призов
    var prizeRules: String = "prize rules"
//40. Список разыгрываемых призов
    val prizes: String = "prizes"
//41. Контактная информация экстренных служб, медицинского персонала и других важных служб, для внутреннего пользования.
    val emergencyContacts: String = "emergency contacts"
//42. Особые условия для участников с ограниченными возможностями
    val specialConditions: String = "special conditions"
//43. Общее настроение участников (определяется опросами)
    var participantsMood: String = "participants Mood"
//44. Подробный план хакатона, включающий время и содержание каждого сегмента
    lateinit var hachatenPlan: String
//45. Имя знаменитого специального гостя,
    lateinit var specialGuest: String
//46. Максимальное количество людей,
    val maxMembersQty: Int = 150
//47 Количество часов, отведенное каждой команде для работы над проектом.
    val hoursPerTeam: Byte = 56
