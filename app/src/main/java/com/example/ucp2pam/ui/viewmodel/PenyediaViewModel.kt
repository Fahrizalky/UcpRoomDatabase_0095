package com.example.ucp2pam.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2pam.GudangApp

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            HomeBarViewModel(
                gudangApp().containerApp.repositoryBarang
            )
        }
        initializer {
            InsertBarViewModel(
                gudangApp().containerApp.repositoryBarang
            )
        }
        initializer {
            DetailBarViewModel(
                createSavedStateHandle(),
                gudangApp().containerApp.repositoryBarang
            )
        }
        initializer {
            UpdateBarViewModel(
                createSavedStateHandle(),
                gudangApp().containerApp.repositoryBarang
            )
        }
        initializer {
            HomeSupViewModel(
                gudangApp().containerApp.repositorySuplier
            )
        }
        initializer {
            InsertSupViewModel(
                gudangApp().containerApp.repositorySuplier
            )
        }
    }
}

fun CreationExtras.gudangApp(): GudangApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as GudangApp)

