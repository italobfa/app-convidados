package com.example.convidados.service.constants

class GuestConstant private constructor(){
    companion object{
        const val GUESTID = "guestID"
    }

    object FILTER{
        const val EMPTY = 0
        const val PRESENT = 1
        const val ABSENT = 2
    }
}