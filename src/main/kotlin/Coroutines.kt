import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
val a = async(CommonPool) {
    42
}

val b = async(CommonPool) {
    delay(1000)
    a.await() * 2
}

fun main(args: Array<String>) {
    runBlocking {
        println(a.await())
        println(b.await())
    }
}