package com.woowrale.microservice.proxyedge.data.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Personas {

	private List<Persona> personas;

	public Personas() {
		super();
		personas = new ArrayList<Persona>();
	}

}
