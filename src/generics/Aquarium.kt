package generics

open class WaterSupply(var needsProcessing: Boolean)

class TapWater: WaterSupply(true){
    fun addChemicalCleaners(){
        needsProcessing = false
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply(true){
    fun filter(){
        needsProcessing = false
    }
}

class Aquarium<out T: WaterSupply>(val waterSupply: T){
    fun addWater(cleaner: Cleaner<T>){
        if (waterSupply.needsProcessing){
            cleaner.clean(waterSupply)
        }
        println("water added")
    }
}


interface Cleaner<in T: WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater) = waterSupply.addChemicalCleaners()
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun <T: WaterSupply>isWaterClean(aquarium: Aquarium<T>){
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}

//inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R


fun genericsExample(){
//    val aquarium = Aquarium(TapWater())
//    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
//    aquarium.waterSupply.addChemicalCleaners()
//    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
//    val aquarium2 = Aquarium("string")
//    println(aquarium2.waterSupply)
//    val aquarium3 = Aquarium(null)
//    if (aquarium3.waterSupply == null){
//        print("waterSupply is null")
//    }
//    val aquarium4 = Aquarium(LakeWater())
//    aquarium4.waterSupply.filter()
//    aquarium4.addWater()
//    val aquarium = Aquarium(TapWater())
//    addItemTo(aquarium)
//    val cleaner = TapWaterCleaner()
//    val aquarium = Aquarium(TapWater())
//    aquarium.addWater(cleaner)

//    val aquarium = Aquarium(TapWater())
//    isWaterClean<TapWater>(aquarium)
//
//    val aquarium = Aquarium(TapWater())
//    println(aquarium.hasWaterSupplyOfType<TapWater>())
//    val aquarium = Aquarium(TapWater())
//    println(aquarium.waterSupply.isOfType<TapWater>())

    val aquarium = Aquarium(TapWater())
    println(aquarium.hasWaterSupplyOfType<TapWater>())
}


fun main() {
    genericsExample()
}