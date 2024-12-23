package com.example.ucp2pam.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2pam.data.entity.Barang
import com.example.ucp2pam.data.entity.Suplier
import kotlinx.coroutines.flow.Flow

@Dao
interface BarangDao {
    @Query("SELECT * FROM barang ORDER BY nama ASC")
    fun getAllBarang(): Flow<List<Barang>>

    @Insert
    suspend fun insertBarang( barang: Barang )

    @Update
    suspend fun updateBarang( barang: Barang )

    @Delete
    suspend fun deleteBarang( barang: Barang )

    @Query("SELECT * FROM barang WHERE nama = :nama")
    fun getNamaBarang(nama: String): Flow<Barang>

    @Query("SELECT * FROM suplier WHERE nama = :nama")
    fun getNamaSuplier(nama: String): Flow<Suplier>
}
