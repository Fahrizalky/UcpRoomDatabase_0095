package com.example.ucp2pam.repository

import com.example.ucp2pam.data.dao.BarangDao
import com.example.ucp2pam.data.entity.Barang
import com.example.ucp2pam.data.entity.Suplier
import kotlinx.coroutines.flow.Flow

class LocalRepositoryBarang(
    private val barangDao: BarangDao
): RepositoryBarang {

    override suspend fun insertBrg(barang: Barang) {
        barangDao.insertBarang(barang)
    }

    override suspend fun deleteBrg(barang: Barang) {
        return barangDao.deleteBarang(barang)
    }

    override suspend fun updateBrg(barang: Barang) {
        return barangDao.updateBarang(barang)
    }

    override fun getAllBrg(): Flow<List<Barang>> {
        return barangDao.getAllBarang()
    }

    override fun getNamaBrg(nama: String): Flow<Barang> {
        return barangDao.getNamaBarang(nama)
    }

    override fun getNamaSpl(nama: String): Flow<Suplier> {
        return barangDao.getNamaSuplier(nama)
    }
}
