import java.math.BigDecimal

// sensible type
val name = "Tom Cruise"
val splitName = name.split(' ')

val i = 10

// compile error
// val halfAName = name / 2

fun lastName(name: String) = name.split(' ').last()


// data class
// hashCode()
// toString()
// equals()
// with properties

// Kotlin compiler vs you compiler
data class StoreInKotlin(val id: Int, val name: String, val products: List<ProductInKotlin>? = null)

data class ProductInKotlin(val name: String, val price: Int)

// high-order function

fun add(x: Int, y: Int) = x + y

fun highOrder(x: Int, y: Int, func: (Int, Int) -> Int): Int = func(x, y)

fun highOrderSingle(x: Int, func: (Int) -> Int): Int = func(x)

open class Closeable {
    fun close() {
       println("Object closed.")
    }
}

fun using(obj: Closeable, block: () -> Unit) {
    try {
        block()
    } finally {
        obj.close()
    }
}

object someObj: Closeable()

// Extension
fun String.println() = println(this)

// infix
open class Student(var name: String): Person() {
    infix fun says(str: String) {
        ("$name says $str at school.").println()
    }
}

open class FTE(var name: String): Person() {
    infix fun says(str: String) {
        ("$name says $str in Microsoft.").println()
    }
}

open class Person

object A: Person() {
    infix fun student(name: String) = Student(name)
    infix fun MSer(name: String) = FTE(name)
}

// end infix

private val Int.bd: BigDecimal
    get() {
        return BigDecimal(this)
    }

fun main(args:Array<String>) {
    println(StoreInKotlin(1, "MS", listOf(ProductInKotlin("Surface", 8888), ProductInKotlin("Windows", 2333))))

    println(highOrder(1, 2, ::add))

    highOrderSingle(1, { x -> x + 1 })

    highOrderSingle(1, { it + 1 })

    highOrderSingle(1) { it + 1 }

    using(someObj) {
        println("Do anything before closed.")
        println("Do anything more before closed.")
    }

    "Hello World".println()


    // Limited infix
    A student "小茗同学" says "hello world"
    A MSer "Shenglan" says "一点游戏体验都没有"

    var bigDecimal = BigDecimal(1)
    var bd = 1.bd
    var longer = 100L
}

// java library integration
