package com.woowrale.microservice.personas.data.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.woowrale.microservice.personas.data.model.Persona;
import com.woowrale.microservice.personas.data.model.Personas;
import com.woowrale.microservice.personas.data.repository.PersonasRepository;

/**
 * The Class PersonasService.
 */
@Component
public class PersonasService {

	/** The repository. */
	@Autowired
	private PersonasRepository repository;

	/**
	 * Insert persona.
	 *
	 * @param persona the persona
	 */
	public void insertPersona(Persona persona) {
		repository.save(persona);
	}

	/**
	 * Delete persona.
	 *
	 * @param id the id
	 */
	public void deletePersona(String id) {
		repository.deleteById(id);
	}

	/**
	 * Update.
	 *
	 * @param id the id
	 * @param persona the persona
	 */
	public void update(String id, Persona persona) {
		Optional<Persona> pUpdate = repository.findById(id);
		
		pUpdate.get().setNombre(persona.getNombre());
		pUpdate.get().setApellidoPaterno(persona.getApellidoPaterno());
		pUpdate.get().setApellidoMaterno(persona.getApellidoMaterno());
		pUpdate.get().setEdad(persona.getEdad());
		repository.save(pUpdate.get());
	}

	/**
	 * Search all.
	 *
	 * @return the personas
	 */
	public Personas searchAll() {
		Personas personas = new Personas();
		Iterable<Persona> iterator = repository.findAll();
		for (Persona persona : iterator) {
			personas.getPersonas().add(persona);
		}
		return personas;
	}

	/**
	 * Search by id.
	 *
	 * @param id the id
	 * @return the personas
	 */
	public Personas searchById(String id) {
		Personas personas = new Personas();
		Optional<Persona> persona = repository.findById(id);
		personas.getPersonas().add(persona.get());
		return personas;
	}

}
