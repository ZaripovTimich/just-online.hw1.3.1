fun main() {
    val time = 86400
    val status = agoToText(time)

    print("был(а) в сети $status")
}

fun agoToText(time: Int): String {
    return when (time) {
        in 0..60 -> "только что"
        in 61..60*60 -> convertMinuts(time)
        in 60 * 60 + 1..24 * 60 * 60 -> convertHour(time)
        in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> "сегодня"
        in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> "вчера"
        !in 0..24 * 60 * 60 * 3 -> "давно"
        else -> "Что-то пошло не так..."
    }
}

fun convertHour(time: Int): String {
    val result = time / 60 / 60

    return if (result % 10 == 1 && result % 100 != 11) {
        "$result час назад"
    } else if (result % 10 in 2..4) {
        "$result часа назад"
    } else {
        "$result часов назад"
    }
}

fun convertMinuts(time: Int): String {
    val result = time / 60

    return if (result % 10 == 1 && result % 100 != 11) {
        "$result минуту назад"
    } else if (result % 10 in 2..4) {
        "$result минуты назад"
    } else {
        "$result минут назад"
    }
}