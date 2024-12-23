package com.example.ucp2pam.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2pam.data.entity.Barang
import com.example.ucp2pam.repository.RepositoryBarang
import kotlinx.coroutines.launch


class InsertBarViewModel(private val repositoryBarang: RepositoryBarang): ViewModel(){

    var uiStateBrg by mutableStateOf(BarUIState())
    fun updateState(barangEvent: BarangEvent){
        uiStateBrg = uiStateBrg.copy(
            barangEvent = barangEvent
        )
    }

    private fun validateFields(): Boolean{
        val event = uiStateBrg.barangEvent
        val errorState = FormErrorStateBar(
            nama = if (event.nama.isNotEmpty()) null else "Nama Tidak Boleh Kosong",
            deskripsi = if (event.deskripsi.isNotEmpty()) null else "Deskripsi Tidak Boleh Kosong",
            harga = if (event.harga.isNotEmpty()) null else "Harga Tidak Boleh Kosong",
            stok = if (event.stok.isNotEmpty()) null else "Stok Tidak Boleh Kosong",
            namaSuplier = if (event.namaSuplier.isNotEmpty()) null else "Nama Suplier Tidak Boleh Kosong",

            )

        uiStateBrg = uiStateBrg.copy(isEntrValid = errorState)
        return errorState.isValid()
    }

    fun saveData(){
        val currentEvent = uiStateBrg.barangEvent

        if (validateFields()){
            viewModelScope.launch {
                try {
                    repositoryBarang.insertBrg(currentEvent.toBarangEntity())
                    uiStateBrg = uiStateBrg.copy(
                        snackbarMessage = "Data Berhasil Ditambah",
                        barangEvent = BarangEvent(),
                        isEntrValid = FormErrorStateBar()
                    )
                } catch (e: Exception){
                    uiStateBrg = uiStateBrg.copy(
                        snackbarMessage = "Data gagal disimpan"
                    )
                }
            }
        } else{
            uiStateBrg = uiStateBrg.copy(
                snackbarMessage = "Input Tidak Valid. Periksa Data Anda."
            )
        }
    }

    fun resetSnackBarMessage(){
        uiStateBrg = uiStateBrg.copy(snackbarMessage = null)
    }
}

data class BarUIState(
    val barangEvent: BarangEvent = BarangEvent(),
    val isEntrValid: FormErrorStateBar = FormErrorStateBar(),
    val snackbarMessage: String? = null
)

data class FormErrorStateBar(
    val id: Int? = null,
    val nama: String? = null,
    val deskripsi: String? = null,
    val harga: String? = null,
    val stok: String? = null,
    val namaSuplier: String? = null,
){
    fun isValid(): Boolean{
        return id == null &&
                nama == null &&
                deskripsi == null &&
                harga == null &&
                stok == null &&
                namaSuplier == null
    }
}


fun BarangEvent.toBarangEntity(): Barang = Barang(
    id = id,
    nama = nama,
    deskripsi = deskripsi,
    harga = harga,
    stok = stok,
    namaSuplier = namaSuplier,
)

data class BarangEvent(
    val id: Int = 0,
    val nama: String = "",
    val deskripsi: String = "",
    val harga: String = "",
    val stok: String = "",
    val namaSuplier: String = "",
)

