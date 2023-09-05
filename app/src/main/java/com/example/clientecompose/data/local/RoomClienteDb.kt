package com.example.clientecompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.clientecompose.data.local.entity.ClienteEntity
import com.example.clientecompose.data.local.dao.ClienteDao

@Database(
    entities = [
        ClienteEntity::class,
    ],
    version = 1
)
abstract class RoomClienteDb: RoomDatabase() {
    abstract val clienteDao : ClienteDao
}