import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun Application.module() {
    install(CallLogging)
    install(Routing) {
        get("/") {
            call.respondText("Hello World!111")
        }
    }
}

fun main() {
    embeddedServer(Netty, 8080, watchPaths = listOf("ApplicationKt"), module = Application::module).start()
}