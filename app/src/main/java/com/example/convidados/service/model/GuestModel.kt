package com.example.convidados.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//o room vai usar os atributos das entidades, para gerar a tabela.

@Entity(tableName = "Guest")
class GuestModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "presence")
    var presence: Boolean = true
}