package com.example.ucp2pam.data.repository

import com.example.ucp2pam.data.dao.BarangDao
import com.example.ucp2pam.data.entity.Barang
import kotlinx.coroutines.flow.Flow

class LocalRepositoryBrg (
    private val barangDao : BarangDao
) : RepositoryBrg{

    override suspend fun insertBrg(barang: Barang) {
        barangDao.insertBarang(barang)
    }
    override suspend fun deleteBrg(barang: Barang) {
        barangDao.deleteBarang(barang)
    }

    override fun getAllBrg(): Flow<List<Barang>> =
        barangDao.getAllBarang()

    override fun getBrg(id: String): Flow<Barang> =
        barangDao.getBarang(id)

    override suspend fun updateBrg(barang: Barang) {
        barangDao.updateBarang(barang)
    }
}