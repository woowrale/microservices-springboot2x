package com.woowrale.microservice.proxyedge.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class ProxyEdgeServiceController {

	@GetMapping("/")	
	public String index() {
		return "/index";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("/about")
	public String about() {
		return "/about";
	}
	
	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

	@GetMapping("/404")
	public String error404() {
		return "/error/404";
	}

}
