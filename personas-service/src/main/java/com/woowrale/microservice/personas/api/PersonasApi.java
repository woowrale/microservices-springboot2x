package com.woowrale.microservice.personas.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.woowrale.microservice.personas.data.model.Persona;
import com.woowrale.microservice.personas.data.model.Personas;
import com.woowrale.microservice.personas.data.service.PersonasService;

import io.swagger.annotations.ApiOperation;

/**
 * The Class PersonasApi.
 */
@RefreshScope
@RestController
public class PersonasApi {

	/** The service. */
	@Autowired
	private PersonasService service;

	/**
	 * Servicio REST para insertar una persona.
	 *
	 * @param persona the persona
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "/add", notes = "Se inserta una persona en la bbdd", code = 200, produces = "application/json")
	@RequestMapping(value = "/personas", method = RequestMethod.PUT)
	public @ResponseBody void insert(@RequestBody Persona persona) {
		service.insertPersona(persona);
	}

	/**
	 * Servicio REST para eliminar una persona.
	 *
	 * @param id the id
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "/delete", notes = "Se elimina un registro de la bbdd", code = 200, produces = "application/json")
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable(value = "id") String id) {
		service.deletePersona(id);
	}

	/**
	 * Servicio REST para recuperar informacion.
	 *
	 * @return the personas
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "/search", notes = "Se recuperan los registros de la bbdd", code = 200, produces = "application/json", response = Personas.class)
	@RequestMapping(value = "/personas", method = RequestMethod.GET)
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
	@GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "/search", notes = "Se recuperan los registros de la bbdd", code = 200, produces = "application/json", response = Personas.class)
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.GET)
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
	@GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "/update", notes = "Se actualiza un registro.", code = 200, produces = "application/json", response = Void.class)
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.POST)
	public @ResponseBody void read(@PathVariable(value = "id") String id, @RequestBody Persona persona) {
		service.update(id, persona);
	}

}
