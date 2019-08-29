package com.woowrale.microservice.proxyedge.data.model;

import lombok.Data;

@Data
public class Persona {
	
	private String id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer edad;

}
