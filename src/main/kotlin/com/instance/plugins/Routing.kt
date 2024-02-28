package com.instance.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.instance.web.components.*
import kotlinx.html.*
fun Application.configureRouting() {//r
    routing {
        get("/") {
            call.respondHtml(HttpStatusCode.OK){
                index()
            }
        }
        route("/components"){
            get("/dashboard"){
                call.respondHtml {
                    body {
                        dashboard()
                    }
                }
            }
            get ("/team"){
                call.respondHtml {
                    body {
                        team()
                    }
                }
            }
            get("/projects"){
                call.respondHtml {
                    body {
                        projects()
                    }
                }
            }

        }
    }
}
