package com.example.clientecompose.data.local.dao

import androidx.room.*
import com.example.clientecompose.data.local.entity.ClienteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClienteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(clienteEntity: ClienteEntity)

    @Query(
        """
        SELECT * 
        FROM Cliente
        WHERE ClienteId=:clienteId
        LIMIT 1
    """
    )

    suspend fun replace(clienteId: Int): ClienteEntity?

    @Query("SELECT * FROM Cliente")
    fun getList(): Flow<List<ClienteEntity>>
}