import java.util.*
//
//
//fun isTooHot(temperature: Int) = temperature > 30
//
//fun isDirty(dirty: Int) = dirty > 30
//
//fun isSunday(day: String) = day == "Sunday"
//
//fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
//    return when {
//        isTooHot(temperature) -> true
//        isDirty(dirty) -> true
//        isSunday(day) ->  true
//        else -> false
//    }
//}
//
//fun randomDay(): String {
//    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
//    return week[Random().nextInt(week.size)]
//}
//
//fun fishFood (day : String) : String {
//    val food : String
//    when (day) {
//        "Monday" -> food = "flakes"
//        "Wednesday" -> food = "redworms"
//        "Thursday" -> food = "granules"
//        "Friday" -> food = "mosquitoes"
//        "Sunday" -> food = "plankton"
//        else -> food = "nothing"
//    }
//    return food
//}
//
//fun feedTheFish() {
//    val day = randomDay()
//    val food = fishFood(day)
//    println("Today is $day and the fish eat $food")
//    println("Change water: ${shouldChangeWater(day)}")
//}
//
//fun swim(speed: String ="fast") {
//    println("swimming $speed")
//}
//
//fun main(args: Array<String>) {
//    feedTheFish()
//    swim()
//    swim("slow")
//    swim(speed="turtle-like")
//}

fun main() {
    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // eager, creates a new list
    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")

    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter{it[0] == 'p'}.map{
        println("access: $it")
        it
    }
    println("---------------")
    print("filtered: ${lazyMap2.toList()}")
}