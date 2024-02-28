package com.instance.web.components
import kotlinx.html.*
import kotlinx.html.stream.createHTML
import kotlinx.html.FlowContent


fun FlowContent.dashboard() = div {
    id = "content"
    header {
        classes = setOf("bg-white", "shadow")
        div {
            classes = setOf("mx-auto", "max-w-7xl", "px-4", "py-7", "sm:px-6","lg:px-8")
            h1 {
                classes = setOf("text-3xl", "font-bold", "tracking-tight", "text-gray-900")
                +"Dashboard"
            }
        }
    }
}
fun FlowContent.team() = div{
    id = "content"
    header{
        classes = setOf("bg-gray-100", "shadow")
        div{
            classes = setOf("mx-auto", "max-w-7xl", "px-4","sm:px-6","lg:px-8")
            h1{
                classes = setOf("text-3xl","font-bold", "tracking-tight", "text-gray-900")
                +"Team"
            }
        }
    }
    main{
        classes = setOf("mx-auto", "max-w-7xl", "px-4","sm:px-6","lg:px-8")
    }
}
fun FlowContent.projects() = div{
    id = "content"
    header{
        classes = setOf("bg-red", "shadow")
        div{
            classes = setOf("mx-auto", "max-w-7xl", "px-4","sm:px-6","lg:px-8")
            h1{
                classes = setOf("text-3xl","font-bold", "tracking-tight", "text-gray-900")
                +"Projects"
            }
        }
    }
    main{
        classes = setOf("mx-auto", "max-w-7xl", "px-4","sm:px-6","lg:px-8")
        p{
            +"HIr"}
    }
}
fun HTML.index() {
    classes = setOf("h-full", "bg-gray-200")
    head{
        title{
            +"Kotlin + HTMX+ Tailwind"
        }
        link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/tailwindcss@^2.0/dist/tailwind.min.css")
        //script{ src = "https://cdn.tailwind.css"}
        script{ src = "https://unpkg.com/htmx.org@1.9.10"}
    }
    body{
        classes = setOf("h-full")
        div{
            classes = setOf("min-h-full")
            navbar("Dashboard","Team","Projects","Calendar","Shop")

            dashboard()
        }
    }
}
fun FlowContent.navbar(vararg tabs: String) = nav {
    classes = setOf("bg-gray-800")
    div {
        classes = setOf("mx-auto", "max-w-7xl", "px-4","sm:px-6","lg:px-8")
        div{
            classes = setOf("flex", "h-24", "items-center","justify-between")
            div{
                classes = setOf("flex","items-center")
                div {
                    classes = setOf("flex-shrink-0")
                    div {
                        classes = setOf("block")
                        div {
                            classes = setOf("ml-10", "flex", "items-baseline", "space-x-4")
                            tabs.map {
                                a {
                                    attributes["hx-get"] = "/components/${it.lowercase()}"
                                    attributes["hx-target"] = "#content"
                                    href = "#"
                                    classes = setOf(
                                        "text-gray-300",
                                        "hover:bg-gray-700",
                                        "hover:text-white",
                                        "rounded-md",
                                        "px-3",
                                        "py-2",
                                        "text-sm",
                                        "font-medium"
                                    )
                                    +it
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}