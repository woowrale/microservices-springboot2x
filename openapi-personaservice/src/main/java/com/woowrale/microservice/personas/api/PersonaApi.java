package com.woowrale.microservice.personas.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woowrale.microservice.personas.data.model.Persona;
import com.woowrale.microservice.personas.data.model.Personas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface PersonaApi {

	@Operation(summary = "Create a new persona", tags = { "persona" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "persona created"),
			@ApiResponse(responseCode = "400", description = "invalid user operation"),
			@ApiResponse(responseCode = "404", description = "url not found") })
	@PutMapping(value = "/personas", consumes = { "application/json" })
	public @ResponseBody void insert(@RequestBody Persona persona);

	/**
	 * Servicio REST para eliminar una persona.
	 *
	 * @param id the id
	 */
	@Operation(summary = "Delete a persona", tags = { "persona" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "persona created"),
			@ApiResponse(responseCode = "400", description = "invalid user operation"),
			@ApiResponse(responseCode = "404", description = "url not found") })
	@DeleteMapping(value = "/personas/{id}", produces = { "application/json" })
	public @ResponseBody void delete(@PathVariable(value = "id") String id);

	/**
	 * Servicio REST para recuperar informacion.
	 *
	 * @return the personas
	 */
	@Operation(summary = "Search all personas", tags = { "persona" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "persona created"),
			@ApiResponse(responseCode = "400", description = "invalid user operation"),
			@ApiResponse(responseCode = "404", description = "url not found")})
	@GetMapping(value = "/personas", produces = { "application/json" })
	public @ResponseBody Personas searchAll();

	/**
	 * Servicio REST para recuperar informacion.
	 *
	 * @param id the id
	 * @return the personas
	 */
	@Operation(summary = "Search persona by id", tags = { "persona" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "persona created"),
			@ApiResponse(responseCode = "400", description = "invalid user operation"),
			@ApiResponse(responseCode = "404", description = "url not found")})
	@GetMapping(value = "/personas/{id}", produces = { "application/json" })
	public @ResponseBody Personas searchById(@PathVariable(value = "id") String id);

	/**
	 * Servicio REST para actualizar informacion.
	 *
	 * @param id      the id
	 * @param persona the persona
	 */
	@Operation(summary = "Update a persona", tags = { "persona" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "persona created"),
			@ApiResponse(responseCode = "400", description = "invalid user operation"),
			@ApiResponse(responseCode = "404", description = "url not found") })
	@PostMapping(value = "/personas/{id}", consumes = { "application/json" })
	public @ResponseBody void read(@PathVariable(value = "id") String id, @RequestBody Persona persona);

}
