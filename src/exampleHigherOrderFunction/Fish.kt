package exampleHigherOrderFunction

data class Fish(var name: String)

fun fishExamples(){
//    val fish = Fish("splashy")
//    inline myWith(fish.name){
//        fish.name.capitalize()
//    }
//    fish.run{name}
//
//    val fish2 = Fish(name = "slashy").apply{name = "sharky"}
//    println(fish2.name)
//
//    println(fish.let { it.name.capitalize()}
//        .let{it + "fish"}
//        .let{it.length}
//        .let{it + 31})
//    println(fish)

}

//myWith(fish.name, object: Function1<String, Unit> {
//    override fun invoke(name: String) {ame.capitalize()}
//})

fun runExample(){
//    val runnable = object: Runnable{
//        override fun run(){
//            println("I'm a Runnable")
//        }
//    }
    JavaRun.runNow({println("Last parameter is a lambda as a Runnable")})
}
fun main(){
//    fishExamples()

    runExample()
}