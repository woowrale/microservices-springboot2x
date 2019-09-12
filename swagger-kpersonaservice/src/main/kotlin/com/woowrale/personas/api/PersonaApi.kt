package com.woowrale.personas.api

import com.woowrale.personas.data.model.Persona
import com.woowrale.personas.data.model.Personas
import com.woowrale.personas.data.service.PersonaService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.*

@RefreshScope
@RestController
class PersonasApi {

    @Autowired
    private lateinit var service: PersonaService

    @ApiOperation(value = "/add", notes = "Se inserta una persona en la bbdd", code = 200, produces = "application/json")
    @PutMapping(value = ["/personas"])
    @ResponseBody
    fun insert(@RequestBody persona: Persona) {
        service.insertPersona(persona)
    }

    @ApiOperation(value = "/delete", notes = "Se elimina un registro de la bbdd", code = 200, produces = "application/json")
    @DeleteMapping(value = ["/personas/{id}"])
    @ResponseBody
    fun delete(@PathVariable(value = "id") id: String) {
        service.deletePersona(id)
    }

    @ApiOperation(value = "/search", notes = "Se recuperan los registros de la bbdd", code = 200, produces = "application/json", response = Personas::class)
    @GetMapping(value = ["/personas"])
    @ResponseBody
    fun searchAll(): Personas {
        return service.searchAll()
    }

    @ApiOperation(value = "/search", notes = "Se recuperan los registros de la bbdd", code = 200, produces = "application/json", response = Personas::class)
    @GetMapping(value = ["/personas/{id}"])
    @ResponseBody
    fun searchById(@PathVariable(value = "id") id: String): Personas {
        return service.searchById(id)
    }

    @ApiOperation(value = "/update", notes = "Se actualiza un registro.", code = 200, produces = "application/json", response = Void::class)
    @PostMapping(value = ["/personas/{id}"])
    @ResponseBody
    fun read(@PathVariable(value = "id") id: String, @RequestBody persona: Persona) {
        service.update(id, persona)
    }

}
