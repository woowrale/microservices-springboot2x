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
        val pUpdate = Persona(pFound.id, persona.nombre, persona.apellidoPaterno, persona.apellidoMaterno, persona.edad)
        repository.save(pUpdate)
    }

    fun searchAll(): Personas {
        val personalList = mutableListOf<Persona>()
        val iterator = repository.findAll()
        for (persona in iterator) {
            personalList.add(persona)
        }

        return Personas(personalList)
    }

    fun searchById(id: String): Personas {
        val personalList = mutableListOf<Persona>()
        val persona = repository.findById(id).get()
            personalList.add(persona)
        return Personas(personalList)
    }

}
