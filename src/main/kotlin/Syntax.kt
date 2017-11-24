import kotlin.system.measureTimeMillis

// 01 Explosive Placeholders
class Test: Runnable {
    override fun run() {
        if (something()) {
            something()
        } else {
            TODO("Not implement")
        }
    }
}

fun something(): Boolean = true

// 02 Semantic Validation
fun join(sep: String, strings: List<String>) {
    if (sep.length > 2) {
        throw IllegalArgumentException("sep.length < 2: " + sep)
    }
}

// throws IllegalArgumentException
//require(value: Boolean)
//require(value: Boolean, lazyMessage: () -> Any)

//requireNotNull(value: T?): T
//requireNotNull(value: T?, lazyMessage: () -> Any): T

// throws IllegalStateException
//check(value: Boolean)
//check(value: Boolean, lazyMessage: () -> Any)

//checkNotNull(value: T?): T
//checkNotNull(value: T?, lazyMessage: () -> Any): T

// throws AssertionError
//assert(value: Boolean)
//assert(value: Boolean, lazyMessage: () -> Any)

// 03 Anything and Nothing
//        Any
//Runnable    Int
//        Nothing

//If a function retures nothing, there will be no change for following code to run.

// 04 Let
class Foo {
    @Volatile var user: User? = null

    fun doSomething() {
        user?.let { user ->
            // user not null, only read once!
        }

        user?.also { user ->
            // user not null, only read once!
        }
    }

    fun test() {
        something().let { result ->
            // use result multiple times
        }
    }
}

// 05 Multiline String
val string = """|foo
                |bar
                |baz""".trimIndent()

// 06 Lazy but Speedy
class NamePrinter(val firstName: String, val lastName: String) {
    val fullName: String by lazy { "$firstName $lastName" }

    fun printName() {
        println(fullName)
    }
}

// 07 Code Block Measurement
fun test() {
    val helloTook = measureTimeMillis {
        println("Hello world")
    }

    println("Saying 'hello' took ${helloTook}ms")
}

// 08 Deprecation Levels
@Deprecated("Use strings.joinToString(sep).", level = DeprecationLevel.HIDDEN)
fun joinCustomized(sep: String, strings: List<String>): Unit {
    //...
    return
}

// 09 Deprecation Replacement
@Deprecated("User Guava's Joiner.",
        replaceWith = ReplaceWith("Joiner.on(sep).join(strings)",
                imports = "com.google.common.base.Joiner"))
fun joinAnotherCustomized(sep: String, strings: List<String>): Unit {
    //...
    return
}

fun testDeprecated() {
    joinAnotherCustomized(",", listOf("me", "you"))
}

// 10 Erasing Erasure
@JvmName("sortStrings")
fun sort(strings: List<String>) {
    // ...
}

@JvmName("sortInts")
fun sort(ints: List<Int>) {
    // ...
}