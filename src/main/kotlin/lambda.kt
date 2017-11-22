fun printMessageWithPrefix(message: Collection<String>, prefix: String) {
    message.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErros = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")) {
            clientErros++
        } else if(it.startsWith("5")) {
            serverErrors++
        }
    }
}

// fun tryToCountButtonClicks(button: Button): Int {
//    var clicks = 0
//    button.onClick { clicks++ }
//    return clicks
// }

// filter/map/all/any/count/find/groupBy/flatMap/flatten

// asSequence() Delay evaluation

// 中间和末端计算的惰性求值

// 待接收者的lambda "with" / "apply"
fun alphabet(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }

        append("\nNow I know the alphabet!")
        this.toString()
    }
}

fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }

    append("\nNow I know the alphabet!")
    append("")
}.toString()



fun main(args: Array<String>) {

}