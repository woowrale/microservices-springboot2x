package com.woowrale.proxyedge.api

import com.woowrale.proxyedge.data.model.Persona
import com.woowrale.proxyedge.data.model.Personas
import com.woowrale.proxyedge.data.repository.ProxyEdgeService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v01/api")
class ProxyEdgeApi {

    @Autowired
    var proxyEdgeService: ProxyEdgeService? = null

    /**
     * Servicio REST para insertar
     */
    @ApiOperation(value = "/add", notes = "Se inserta una persona en la bbdd", code = 200, produces = "application/json", response = Void::class)
    @PutMapping(value = "/dashboard/personas")
    @ResponseBody
    fun insert(@RequestBody persona: Persona) {
        proxyEdgeService!!.insert(persona)
    }

    /**
     * Servicio REST para eliminar
     */
    @ApiOperation(value = "/delete", notes = "Se elimina una persona en la bbdd", code = 200, produces = "application/json", response = Void::class)
    @DeleteMapping(value = "/dashboard/personas/{id}")
    @ResponseBody
    fun insert(@PathVariable(value = "id") id: String) {
        proxyEdgeService!!.delete(id)
    }

    /**
     * Servicio REST para actualizar
     */
    @ApiOperation(value = "/update", notes = "Se actualiza una persona en la bbdd", code = 200, produces = "application/json", response = Void::class)
    @PostMapping(value = "/dashboard/personas/{id}")
    @ResponseBody
    fun update(@PathVariable(value = "id") id: String, @RequestBody persona: Persona) {
        proxyEdgeService!!.update(id, persona)
    }

    /**
     * Servicio REST para obtener
     */
    @ApiOperation(value = "/searchAll", notes = "Se recupera una persona en la bbdd", code = 200, produces = "application/json", response = Personas::class)
    @GetMapping(value = "/dashboard/personas")
    @ResponseBody
    fun searhAll(): Personas {
        return proxyEdgeService!!.searchAll()
    }

    /**
     * Servicio REST para obtener
     */
    @ApiOperation(value = "/searchById", notes = "Se recupera una persona en la bbdd", code = 200, produces = "application/json", response = Personas::class)
    @GetMapping(value = "/dashboard/personas/{id}")
    @ResponseBody
    fun searhById(@PathVariable(value = "id") id: String): Personas {
        return proxyEdgeService!!.searchById(id)
    }

}
