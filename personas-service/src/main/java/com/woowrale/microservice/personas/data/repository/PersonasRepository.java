package com.woowrale.microservice.personas.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.woowrale.microservice.personas.data.model.Persona;

/**
 * The Interface PersonasRepository.
 */
public interface PersonasRepository extends CrudRepository<Persona, String> {

}
