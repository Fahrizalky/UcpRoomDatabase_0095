package com.example.ucp2pam.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ucp2pam.data.entity.Suplier
import kotlinx.coroutines.flow.Flow

@Dao
interface SuplierDao {
    @Insert
    suspend fun insertSuplier(
        suplier: Suplier
    )

    @Query("SELECT * FROM suplier ORDER BY nama ASC")
    fun getAllSuplier(): Flow<List<Suplier>>
}



