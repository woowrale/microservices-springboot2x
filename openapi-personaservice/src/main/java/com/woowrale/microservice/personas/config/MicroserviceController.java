package com.woowrale.microservice.personas.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The Class MicroserviceController.
 */
@Controller
public class MicroserviceController {

	/**
	 * Index.
	 *
	 * @return the string
	 */
	@GetMapping("/")	
	public String index() {
		return "/index";
	}

	/**
	 * Home.
	 *
	 * @return the string
	 */
	@GetMapping("/console")
	public String home() {
		return "/home";
	}

	/**
	 * Login.
	 *
	 * @return the string
	 */
	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	/**
	 * About.
	 *
	 * @return the string
	 */
	@GetMapping("/about")
	public String about() {
		return "/about";
	}
	
	/**
	 * Error 403.
	 *
	 * @return the string
	 */
	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

	/**
	 * Error 404.
	 *
	 * @return the string
	 */
	@GetMapping("/404")
	public String error404() {
		return "/error/404";
	}

}
