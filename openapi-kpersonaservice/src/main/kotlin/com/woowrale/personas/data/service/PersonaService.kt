package com.woowrale.personas.data.service

import com.woowrale.personas.data.model.Persona
import com.woowrale.personas.data.model.Personas
import com.woowrale.personas.data.repository.PersonasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PersonaService {

    @Autowired
    private lateinit var repository: PersonasRepository

    fun insertPersona(persona: Persona) {
        repository.save(persona)
    }

    fun deletePersona(id: String) {
        repository.deleteById(id)
    }

    fun update(id: String, persona: Persona) {
        val pFound = repository.findById(id).get()
        val pUpdate = Persona(pFound.id, pFound.nombre, pFound.apellidoPaterno, pFound.apellidoMaterno, pFound.edad)
        repository.save(pUpdate)
    }

    fun searchAll(): Personas {
        val personasList = mutableListOf<Persona>()
        val iterator = repository.findAll()
        for (persona in iterator) {
            personasList.add(persona)
        }

        return Personas(personasList)
    }

    fun searchById(id: String): Personas {
        val personasList = mutableListOf<Persona>()
        val iterator = repository.findAll()
        for (persona in iterator) {
            personasList.add(persona)
        }

        return Personas(personasList)
    }

}
