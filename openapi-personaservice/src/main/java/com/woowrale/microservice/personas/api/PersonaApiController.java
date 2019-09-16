package com.woowrale.microservice.personas.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.woowrale.microservice.personas.data.model.Persona;
import com.woowrale.microservice.personas.data.model.Personas;
import com.woowrale.microservice.personas.data.service.PersonasService;

/**
 * The Class PersonasApi.
 */
/**
 * @author Carlos
 *
 */
@RefreshScope
@RestController
public class PersonaApiController implements PersonaApi{

	/** The service. */
	@Autowired
	private PersonasService service;

	/**
	 * Servicio REST para insertar una persona.
	 *
	 * @param persona the persona
	 */
	public @ResponseBody void insert(@RequestBody Persona persona) {
		service.insertPersona(persona);
	}

	/**
	 * Servicio REST para eliminar una persona.
	 *
	 * @param id the id
	 */
	public @ResponseBody void delete(@PathVariable(value = "id") String id) {
		service.deletePersona(id);
	}

	/**
	 * Servicio REST para recuperar informacion.
	 *
	 * @return the personas
	 */
	public @ResponseBody Personas searchAll() {
		Personas personas = service.searchAll();
		return personas;
	}

	/**
	 * Servicio REST para recuperar informacion.
	 *
	 * @param id the id
	 * @return the personas
	 */
	public @ResponseBody Personas searchById(@PathVariable(value = "id") String id) {
		Personas personas = service.searchById(id);
		return personas;
	}

	/**
	 * Servicio REST para actualizar informacion.
	 *
	 * @param id the id
	 * @param persona the persona
	 */
	public @ResponseBody void read(@PathVariable(value = "id") String id, @RequestBody Persona persona) {
		service.update(id, persona);
	}

}
