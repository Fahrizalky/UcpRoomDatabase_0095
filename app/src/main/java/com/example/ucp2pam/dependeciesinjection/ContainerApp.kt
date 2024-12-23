package com.example.ucp2pam.dependeciesinjection

import android.content.Context
import com.example.ucp2pam.data.database.GudangDatabase
import com.example.ucp2pam.repository.LocalRepositoryBarang
import com.example.ucp2pam.repository.LocalRepositorySuplier
import com.example.ucp2pam.repository.RepositoryBarang
import com.example.ucp2pam.repository.RepositorySuplier

interface InterfaceContainerApp{
    val repositoryBarang: RepositoryBarang

    val repositorySuplier: RepositorySuplier
}

class ContainerApp(private val context: Context): InterfaceContainerApp{

    override val repositoryBarang: RepositoryBarang by lazy {
        LocalRepositoryBarang(GudangDatabase.getDatabase(context).barangDao())
    }

    override val repositorySuplier: RepositorySuplier by lazy {
        LocalRepositorySuplier(GudangDatabase.getDatabase(context).suplierDao())
    }
}

