class SingletonWithoutLazy private constructor() {
    // Companion Object在类第一次加载时初始化
    companion object {
        var instance = Holder.instance
    }

    private object Holder {
        val instance = SingletonWithoutLazy()
    }
}

class SingletonWithLazy private constructor() {
    companion object {
        val instance: SingletonWithLazy by lazy { SingletonWithLazy() }
    }
}

fun main(args: Array<String>) {
    SingletonWithLazy.instance
}