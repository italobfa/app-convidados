package com.example.convidados.service.model

data class GuestModel(
    val id: Int = 0,
    val name: String?,
    var presence: Boolean
)