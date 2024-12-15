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

data class MhsUIState(
    val mahasiswaEvent: MahasiswaEvent = MahasiswaEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
    val snackBarMessage : String? = null,
)

data class FormErrorState(
    val nim:String?=null,
    val nama:String?=null,
    val jeniskelamin:String?=null,
    val alamat:String?=null,
    val kelas:String?=null,
    val angkatan:String?=null,
){
    fun isValid(): Boolean{
        return nim == null && nama == null
                && jeniskelamin == null && alamat== null
                && kelas == null && angkatan== null
    }
}

//menyimpan input form ke dalam entity
fun MahasiswaEvent.toMahasiswaEntity(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    jeniskelamin = jeniskelamin,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan,
)
//data class variabel yang merupakan data input form
data class MahasiswaEvent(
    val nim : String ="",
    val nama : String ="",
    val jeniskelamin : String ="",
    val alamat : String ="",
    val kelas : String ="",
    val angkatan : String ="",
)