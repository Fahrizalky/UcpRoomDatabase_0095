package com.example.ucp2pam.data.repository

import com.example.ucp2pam.data.dao.SuplierDao
import com.example.ucp2pam.data.entity.Suplier

class LocalRepositorySpl (
    private val suplierDao: SuplierDao
): RepositorySpl{

    override suspend fun insertSpl(suplier: Suplier){
        suplierDao.insertSuplier(suplier)
    }

    override fun getAllSuplier(): List<Suplier>{
        return suplierDao.getAllSuplier()
    }
}