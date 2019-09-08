package com.woowrale.personas.data.repository

import com.woowrale.personas.data.model.Persona
import org.springframework.data.repository.CrudRepository

interface PersonasRepository : CrudRepository<Persona, String>
