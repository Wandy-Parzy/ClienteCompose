package com.example.clientecompose.di

import android.content.Context
import androidx.room.Room
import  com.example.clientecompose.data.local.RoomClienteDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // TODO: Inyectar la base de datos
    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): RoomClienteDb {
        return Room.databaseBuilder(
            context,
            RoomClienteDb::class.java,
            "ClienteDb.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    // TODO: Inyectar el DAO
    @Singleton
    @Provides
    fun providesClienteDao(db: RoomClienteDb) = db.clienteDao
}