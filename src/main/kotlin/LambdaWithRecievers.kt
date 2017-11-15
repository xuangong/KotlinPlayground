data class Request(val query: String, val acceptType: String, val priority: Int)

class Response() {
    constructor(statusCode: Int, statusText: String) : this()
    // Make a class works like a function
    operator fun invoke(statusResult: StatusResult.() -> Unit) = Unit
}

data class StatusResult(var statusCode: Int, var statusText: String)

class RouteHandler(var request: Request, val response: Response)

fun get(path: String, func: RouteHandler.() -> Unit) = func

fun anotherGet(path: String, func: (Request) -> Response) = func

class Manager {
    operator fun invoke(message: String) {}
}

fun main(args: Array<String>) {

    val manager = Manager()
    manager("message")

    val response = Response(-1, "Init")
    get("/index") {
        when (request.acceptType) {
            "" -> response {
                statusCode = 405
                statusText = "Invalid media type"
            }
            else -> response {
                statusCode = 200
                statusText = "ok"
            }
        }
    }(RouteHandler(Request("query1", "", 0), response))
    println(response)

    println(anotherGet("/index", {
            when (it.acceptType) {
                "" -> Response(405, "Invalid media type")
                else -> {
                    Response(200, "ok")
                }
            }
        })(Request("query2", "", 1)))
}