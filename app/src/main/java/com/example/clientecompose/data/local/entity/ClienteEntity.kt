package com.example.clientecompose.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cliente")
data class ClienteEntity (
    @PrimaryKey(autoGenerate = true)
    val clienteid : Int?=null,
    var nombre : String,
)