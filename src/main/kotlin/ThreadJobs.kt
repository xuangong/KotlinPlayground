import kotlin.concurrent.thread

fun main(args: Array<String>) {
    for (i in 1..1_000_000) {
        thread(start = true) {
            Thread.sleep(1000L)
        }
    }
}