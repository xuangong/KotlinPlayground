import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>): Unit = runBlocking {
    println("Starting...")

    val jobs = List(1_000_000) {
        async(CommonPool) {
            delay(1000L)
            1
        }
    }

    println(
            jobs.sumBy { it.await() }
    )
}
