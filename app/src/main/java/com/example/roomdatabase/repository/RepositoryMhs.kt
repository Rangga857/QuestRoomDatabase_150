package com.example.roomdatabase.repository

import com.example.roomdatabase.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow


interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)

    suspend fun deleteMhs(mahasiswa: Mahasiswa)

    suspend fun updateMhs(mahasiswa: Mahasiswa)

    fun getAllMahasiswa(): Flow<List<Mahasiswa>>

    fun getAllMhs() : Flow<List<Mahasiswa>>

    fun getMhs(nim : String) : Flow<Mahasiswa>
}