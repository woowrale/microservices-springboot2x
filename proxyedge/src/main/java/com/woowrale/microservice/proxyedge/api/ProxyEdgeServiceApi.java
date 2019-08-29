package com.woowrale.microservice.proxyedge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.woowrale.microservice.proxyedge.data.model.Persona;
import com.woowrale.microservice.proxyedge.data.model.Personas;
import com.woowrale.microservice.proxyedge.data.repository.PersonasProxyEdgeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v01/api")
public class ProxyEdgeServiceApi {

	@Autowired
	PersonasProxyEdgeService proxyEdgeService;

	/**
	 * Servicio REST para insertar
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "/add", notes = "Se inserta una persona en la bbdd", code = 200, response = Void.class)
	@RequestMapping(value = "/dashboard/personas", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody void insert(@RequestBody Persona persona) {
		proxyEdgeService.insert(persona);
	}

	/**
	 * Servicio REST para eliminar
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "/delete", notes = "Se elimina una persona en la bbdd", code = 200, response = Void.class)
	@RequestMapping(value = "/dashboard/personas/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody void insert(@PathVariable(value = "id") String id) {
		proxyEdgeService.delete(id);
	}
	
	/**
	 * Servicio REST para actualizar
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "/update", notes = "Se actualiza una persona en la bbdd", code = 200, response = Void.class)
	@RequestMapping(value = "/dashboard/personas/{id}", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody void update(@PathVariable(value = "id") String id, @RequestBody Persona persona) {
		proxyEdgeService.update(id, persona);
	}

	/**
	 * Servicio REST para obtener
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "/searchAll", notes = "Se recupera una persona en la bbdd", code = 200, response = Personas.class)
	@RequestMapping(value = "/dashboard/personas", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Personas searhAll() {
		return proxyEdgeService.searchAll();
	}

	/**
	 * Servicio REST para obtener
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ApiOperation(value = "/searchById", notes = "Se recupera una persona en la bbdd", code = 200, response = Personas.class)
	@RequestMapping(value = "/dashboard/personas/{id}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Personas searhById(@PathVariable(value = "id") String id) {
		return proxyEdgeService.searchById(id);
	}

}
