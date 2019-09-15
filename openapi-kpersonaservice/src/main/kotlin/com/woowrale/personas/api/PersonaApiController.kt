package com.woowrale.personas.api

import com.woowrale.personas.data.model.Persona
import com.woowrale.personas.data.model.Personas
import com.woowrale.personas.data.service.PersonaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RefreshScope
@RestController
class PersonaApiController : PersonaApi {

    @Autowired
    private lateinit var service: PersonaService

    override fun insert(@RequestBody persona: Persona) {
        service.insertPersona(persona)
    }

    override fun delete(@PathVariable(value = "id") id: String) {
        service.deletePersona(id)
    }

    override fun searchAll(): Personas {
        return service.searchAll()
    }

    override fun searchById(@PathVariable(value = "id") id: String): Personas {
        return service.searchById(id)
    }

    override fun read(@PathVariable(value = "id") id: String, @RequestBody persona: Persona) {
        service.update(id, persona)
    }
}