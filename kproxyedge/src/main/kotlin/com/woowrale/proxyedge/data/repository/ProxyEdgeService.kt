package com.woowrale.proxyedge.data.repository

import com.woowrale.proxyedge.data.model.Persona
import com.woowrale.proxyedge.data.model.Personas
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.*
import springfox.documentation.annotations.ApiIgnore

@FeignClient(name = "kpersonaservice")
@ApiIgnore
interface ProxyEdgeService {

    /**
     * Servicio REST para insertar una persona
     */
    @RequestMapping(value = "/personas", method = [RequestMethod.PUT])
    @ResponseBody
    fun insert(@RequestBody persona: Persona)

    /**
     * Servicio REST para eliminar una persona
     */
    @RequestMapping(value = "/personas/{id}", method = [RequestMethod.DELETE])
    @ResponseBody
    fun delete(@PathVariable(value = "id") id: String)

    /**
     * Servicio REST para obtener personas
     */
    @RequestMapping(value = "/personas", method = [RequestMethod.GET], headers = ["user:admin", "password:admin"])
    @ResponseBody
    fun searchAll(): Personas

    /**
     * Servicio REST para obtener una persona
     */
    @RequestMapping(value = "/personas/{id}", method = [RequestMethod.GET])
    @ResponseBody
    fun searchById(@PathVariable(value = "id") id: String): Personas

    /**
     * Servicio REST para actualizar una persona
     */
    @RequestMapping(value = "/personas/{id}", method = [RequestMethod.POST])
    @ResponseBody
    fun update(@PathVariable(value = "id") id: String, @RequestBody persona: Persona)

}
