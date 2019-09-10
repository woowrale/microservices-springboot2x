package com.woowrale.personas.data.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_persona")
data class Persona(
        @Id
        val id: String = "",

        val nombre: String = "",

        @Column(name = "apellido_paterno")
        val apellidoPaterno: String = "",

        @Column(name = "apellido_materno")
        val apellidoMaterno: String = "",

        @Column(name = "edad")
        val edad: Int = -1
)

data class Personas(val personas: List<Persona> = emptyList())