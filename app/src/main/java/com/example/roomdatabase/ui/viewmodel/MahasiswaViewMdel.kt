package com.example.roomdatabase.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.entity.Mahasiswa
import com.example.roomdatabase.repository.RepositoryMhs
import kotlinx.coroutines.launch

class MahasiswaViewModel(private val repositoryMhs: RepositoryMhs):ViewModel(){

}


//data class variabel yang merupakan data input form
data class MahasiswaEvent(
    val nim : String ="",
    val nama : String ="",
    val jeniskelamin : String ="",
    val alamat : String ="",
    val kelas : String ="",
    val angkatan : String ="",
)