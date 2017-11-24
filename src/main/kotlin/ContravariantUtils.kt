import typeSafty.getMap

internal object typeSafty {
    fun <K, V> getMap(source: String, firstSplit: String, secondSplit: String): Map<K, V> {

        val result = HashMap<K, V>()
        if (source == "") {
            return result
        }

        val strings = source.split(firstSplit.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (string in strings) {
            val tmp = string.split(secondSplit.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            if (tmp.size == 2) {
                result.put(tmp[0] as K, tmp[1] as V)
                println("${ tmp[0] } -> ${ tmp[1] }")
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val test = "key1:1;key2:2;key:3"
    val map = getMap<String, Int>(test, ";", ":")

    map.forEach {
        println(it.key)
        println(it.value)
    }
}