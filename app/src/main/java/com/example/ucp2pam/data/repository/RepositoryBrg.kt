package com.example.ucp2pam.data.repository

import com.example.ucp2pam.data.entity.Barang
import kotlinx.coroutines.flow.Flow

interface RepositoryBrg {
    suspend fun insertBrg(barang: Barang)
    suspend fun deleteBrg(barang: Barang)
    fun getBrg(id : String) : Flow<Barang>
    fun getAllBrg(): Flow<List<Barang>>
    suspend fun updateBrg(barang: Barang)
}