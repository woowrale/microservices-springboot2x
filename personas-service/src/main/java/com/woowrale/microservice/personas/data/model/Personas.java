package com.woowrale.microservice.personas.data.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data
public class Personas {
	
	/** The personas. */
	private List<Persona> personas;

	/**
	 * Instantiates a new personas.
	 */
	public Personas() {
		super();
		personas = new ArrayList<Persona>();
	}
}
