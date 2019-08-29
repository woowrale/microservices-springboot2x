package com.woowrale.microservice.proxyedge.data.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woowrale.microservice.proxyedge.data.model.Persona;
import com.woowrale.microservice.proxyedge.data.model.Personas;

import springfox.documentation.annotations.ApiIgnore;

@FeignClient(name = "personas-service")
@ApiIgnore
public interface PersonasProxyEdgeService {

	/**
	 * Servicio REST para insertar una persona
	 */
	@RequestMapping(value = "/personas", method = RequestMethod.PUT)
	public @ResponseBody void insert(@RequestBody Persona persona);

	/**
	 * Servicio REST para eliminar una persona
	 */
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable(value = "id") String id);

	/**
	 * Servicio REST para obtener personas
	 */
	@RequestMapping(value = "/personas", method = RequestMethod.GET, headers= {"user:admin","password:admin"})
	public @ResponseBody Personas searchAll();

	/**
	 * Servicio REST para obtener una persona
	 */
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.GET)
	public @ResponseBody Personas searchById(@PathVariable(value = "id") String id);

	/**
	 * Servicio REST para actualizar una persona
	 */
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.POST)
	public @ResponseBody void update(@PathVariable(value = "id") String id, @RequestBody Persona persona);

}
