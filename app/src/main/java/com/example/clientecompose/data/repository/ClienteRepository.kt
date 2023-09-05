package com.example.clientecompose.data.repository

import com.example.clientecompose.data.local.entity.ClienteEntity
import com.example.clientecompose.data.local.dao.ClienteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClienteRepository @Inject constructor(
    private  val clienteDao: ClienteDao
) {
    suspend fun insert(cliente: ClienteEntity) {
        return clienteDao.insert(cliente)
    }

    fun getList(): Flow<List<ClienteEntity>> = clienteDao.getList()
}