package com.example.roomdatabase.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.entity.Mahasiswa
import com.example.roomdatabase.repository.RepositoryMhs
import com.example.roomdatabase.ui.navigation.DestinasiDetail
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class DetailMhsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: RepositoryMhs,
) : ViewModel() {


}
//data class untuk menampung data yang akan ditampilkan di UI
data class DetailUiState(
    val detailUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isLoading : Boolean = false,
    val isError: Boolean = false,
    val errorMessage : String = ""
){
    val isUiEventEmpty : Boolean
        get() = detailUiEvent == MahasiswaEvent()
    val isUiEventNotEmpty : Boolean
        get() = detailUiEvent != MahasiswaEvent()
}

//memindahkan data dari entry ke ui
fun Mahasiswa.toDetailUiEvent() : MahasiswaEvent{
    return MahasiswaEvent(
        nim = nim,
        nama = nama,
        jeniskelamin = jeniskelamin,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan
    )
}