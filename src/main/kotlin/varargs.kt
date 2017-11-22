import kotlinx.coroutines.experimental.handleCoroutineException

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }

fun maxOptimized(c1: Color, c2: Color) =
        when {
            (c1 == Color.RED || c2 == Color.YELLOW) ||
                    (c2 == Color.RED || c1 == Color.YELLOW) -> Color.ORANGE
            (c1 == Color.YELLOW || c2 == Color.BLUE) ||
                    (c2 == Color.YELLOW || c1 == Color.BLUE) -> Color.GREEN
            (c1 == Color.BLUE || c2 == Color.VIOLET) ||
                    (c2 == Color.BLUE || c1 == Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }

interface Expr
class Num(var value: Int): Expr
class Sum(var left: Expr, var right: Expr): Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        return e.value
    }

    if (e is Sum) {
        return eval(e.left) + eval(e.right)
    }

    throw IllegalArgumentException("Unknown expression")
}

data class User(val id: Int, val name: String, val address: String)
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "address")
}


fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(3))))
    for (i in 100 downTo 1 step 2) {
        println(i)
    }
}