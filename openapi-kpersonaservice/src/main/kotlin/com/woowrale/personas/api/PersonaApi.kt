package com.woowrale.personas.api

import com.woowrale.personas.data.model.Persona
import com.woowrale.personas.data.model.Personas
import com.woowrale.personas.data.service.PersonaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.*

@RefreshScope
@RestController
class PersonasApi {

    @Autowired
    private val service: PersonaService? = null

    @PutMapping(value = ["/personas"])
    @ResponseBody
    fun insert(@RequestBody persona: Persona) {
        service!!.insertPersona(persona)
    }

    @DeleteMapping(value = ["/personas/{id}"])
    @ResponseBody
    fun delete(@PathVariable(value = "id") id: String) {
        service!!.deletePersona(id)
    }

    @GetMapping(value = ["/personas"])
    @ResponseBody
    fun searchAll(): Personas {
        return service!!.searchAll()
    }

    @GetMapping(value = ["/personas/{id}"])
    @ResponseBody
    fun searchById(@PathVariable(value = "id") id: String): Personas {
        return service!!.searchById(id)
    }

    @PostMapping(value = ["/personas/{id}"])
    @ResponseBody
    fun read(@PathVariable(value = "id") id: String, @RequestBody persona: Persona) {
        service!!.update(id, persona)
    }

}
