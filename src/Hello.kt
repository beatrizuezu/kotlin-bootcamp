import java.util.*


fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) ->  true
        else -> false
    }
}

fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nexInt(week.size)]
}

fun fishFood(day: String): String {
    var food = ""
    return when (day){
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "mosquitoes"
        "Friday" -> food =  "granules"
        "Saturday" -> food = "lettuce
        "Sunday" -> food = "plankton"
        else -> food = "nothing"
    }
}

fun feedTheFish() {
    val dat = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun swim(speed: Strin ="fast") {
    println("swimming $speed")
}

fun main(args: Array<String>) {
    feedTheFish()
    swim()
    swim("slow")
    swim(speed="turtle-like")
}