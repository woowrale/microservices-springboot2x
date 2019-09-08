package com.woowrale.proxyedge.data.model

data class Persona (
   val id: String? = null,
   val nombre: String? = null,
   val apellidoPaterno: String? = null,
   val apellidoMaterno: String? = null,
   val edad: Int? = null
)

data class Personas (
   val personas: MutableCollection<Persona>? = null
)