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
    var uiState by mutableStateOf(MhsUIState())

    //memperbarui state berdasarkan input pengguna
    fun updateState(mahasiswaEvent: MahasiswaEvent){
        uiState= uiState.copy(
            mahasiswaEvent=mahasiswaEvent
        )
    }

    //function untuk validasi data
    fun validateFields():Boolean{
        val event = uiState.mahasiswaEvent
        val erorState = FormErrorState(
            nim = if (event.nim.isNotEmpty()) null else "NIM tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else " Nama tidak boleh kosong",
            jeniskelamin = if(event.jeniskelamin.isNotEmpty()) null else "Jenis kelamin tidak boleh kosong",
            alamat = if(event.alamat.isNotEmpty()) null else "Alamat tidak boleh kosong",
            kelas = if(event.kelas.isNotEmpty()) null else "Kelas tidak boleh kosong",
            angkatan = if(event.angkatan.isNotEmpty()) null else "Angkatan tidak boleh kosong"
        )
        uiState =uiState.copy(isEntryValid = erorState)
        return erorState.isValid()
    }

    fun saveData(){
        val  currentEvent = uiState.mahasiswaEvent
        if (validateFields()){
            viewModelScope.launch {
                try {
                    repositoryMhs.insertMhs(currentEvent.toMahasiswaEntity())
                    uiState = uiState.copy(
                        snackBarMessage = "Data Berhasil Disimpan",
                        mahasiswaEvent = MahasiswaEvent(),
                        isEntryValid = FormErrorState()
                    )
                } catch (e: Exception){
                    uiState =uiState.copy(
                        snackBarMessage = "Data Gagal Disimpan"
                    )
                }
            }
        }
        else{
            uiState = uiState.copy(
                snackBarMessage = "Input tidak valid. Periksa kembali data yang anda masukkan"
            )
        }
    }
    fun resetSnackBarMessage(){
        uiState=uiState.copy(snackBarMessage = null)
    }
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