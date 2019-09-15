package com.woowrale.personas.api

import com.woowrale.personas.data.model.Persona
import com.woowrale.personas.data.model.Personas
import com.woowrale.personas.data.service.PersonaService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

interface PersonaApi {

    @Operation(summary = "Create a new persona", tags = ["persona"])
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "successful operation"),
        ApiResponse(responseCode = "400", description = "invalid user operation"),
        ApiResponse(responseCode = "404", description = "url not found")])
    @PutMapping(value = ["/personas"], consumes = ["application/json"], produces = ["application/json"])
    @ResponseBody
    fun insert(@RequestBody persona: Persona)

    @Operation(summary = "Delete one persona", tags = ["persona"])
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "successful operation"),
        ApiResponse(responseCode = "400", description = "invalid user operation"),
        ApiResponse(responseCode = "404", description = "url not found")])
    @DeleteMapping(value = ["/personas/{id}"], produces = ["application/json"])
    @ResponseBody
    fun delete(@PathVariable(value = "id") id: String)

    @Operation(summary = "Search all personas", tags = ["persona"])
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "successful operation"),
        ApiResponse(responseCode = "400", description = "invalid user operation"),
        ApiResponse(responseCode = "404", description = "url not found")])
    @GetMapping(value = ["/personas"], produces = ["application/json"])
    @ResponseBody
    fun searchAll(): Personas

    @Operation(summary = "Search one persona", tags = ["persona"])
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "successful operation"),
        ApiResponse(responseCode = "400", description = "invalid user operation"),
        ApiResponse(responseCode = "404", description = "url not found")])
    @GetMapping(value = ["/personas/{id}"], produces = ["application/json"])
    @ResponseBody
    fun searchById(@PathVariable(value = "id") id: String): Personas

    @Operation(summary = "Update one persona", tags = ["persona"])
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "successful operation"),
        ApiResponse(responseCode = "400", description = "invalid user operation"),
        ApiResponse(responseCode = "404", description = "url not found")])
    @PostMapping(value = ["/personas/{id}"], consumes = ["application/json"], produces = ["application/json"])
    @ResponseBody
    fun read(@PathVariable(value = "id") id: String, @RequestBody persona: Persona)

}



