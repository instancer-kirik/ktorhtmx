package com.instance

import com.instance.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    System.setProperty("io.ktor.development", "true")
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module,
        watchPaths = listOf(
            "classes",
            "resources"
        ))
        .start(wait = true)
}

fun Application.module() {
    configureSockets()
    configureTemplating()
    configureSerialization()
    configureHTTP()
    configureRouting()
}
