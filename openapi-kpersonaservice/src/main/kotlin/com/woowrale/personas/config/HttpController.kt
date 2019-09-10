package com.woowrale.personas.config

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HttpController {

    /**
     * Index.
     *
     * @return the string
     */
    @GetMapping("/")
    fun index(): String {
        return "/index"
    }

    /**
     * Home.
     *
     * @return the string
     */
    @GetMapping("/console")
    fun home(): String {
        return "/home"
    }

    /**
     * Login.
     *
     * @return the string
     */
    @GetMapping("/login")
    fun login(): String {
        return "/login"
    }

    /**
     * About.
     *
     * @return the string
     */
    @GetMapping("/about")
    fun about(): String {
        return "/about"
    }

    /**
     * Error 403.
     *
     * @return the string
     */
    @GetMapping("/403")
    fun error403(): String {
        return "/error/403"
    }

    /**
     * Error 404.
     *
     * @return the string
     */
    @GetMapping("/404")
    fun error404(): String {
        return "/error/404"
    }

}