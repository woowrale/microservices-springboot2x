package com.woowrale.microservice.personas.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Instantiates a new persona.
 */
@Data
@Entity
@Table(name = "tbl_persona")
public class Persona {
	
	/** The id. */
	@Id
	private String id;
	
	/** The nombre. */
	private String nombre;
	
	/** The apellido paterno. */
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	/** The apellido materno. */
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	/** The edad. */
	private Integer edad;

}
