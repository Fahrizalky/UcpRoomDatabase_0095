package com.example.ucp2pam.repository

import com.example.ucp2pam.data.entity.Suplier
import kotlinx.coroutines.flow.Flow

interface RepositorySuplier {

    suspend fun insertSpl(suplier: Suplier)

    fun getAllSpl(): Flow<List<Suplier>>
}
