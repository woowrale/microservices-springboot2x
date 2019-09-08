package com.woowrale.personas.data.service

import com.woowrale.personas.data.model.Persona
import com.woowrale.personas.data.model.Personas
import com.woowrale.personas.data.repository.PersonasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PersonaService {

    @Autowired
    private val repository: PersonasRepository? = null

    fun insertPersona(persona: Persona) {
        repository!!.save(persona)
    }

   fun deletePersona(id: String) {
        repository!!.delete(id)
    }

    fun update(id: String, persona: Persona) {
        val pUpdate = Persona(repository!!.findOne(id).id, repository!!.findOne(id).nombre, repository!!.findOne(id).apellidoPaterno, repository!!.findOne(id).apellidoMaterno, repository!!.findOne(id).edad)
        repository.save(pUpdate)
    }

    fun searchAll(): Personas {
        val personasList = mutableListOf<Persona>()
        val iterator = repository!!.findAll()
        for (persona in iterator) {
            personasList.add(persona)
        }

        return Personas(personasList)
    }

    fun searchById(id: String): Personas {
        val personasList = mutableListOf<Persona>()
        val iterator = repository!!.findAll()
        for (persona in iterator) {
            personasList.add(persona)
        }

        return Personas(personasList)
    }

}
