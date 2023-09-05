package com.example.clientecompose.ui.Cliente

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clientecompose.data.local.entity.ClienteEntity
import com.example.clientecompose.data.repository.ClienteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ClienteUiState(
    val clienteList: List<ClienteEntity> = emptyList()
)

@HiltViewModel
class ClienteViewModel @Inject constructor(
    private val clienteRepository: ClienteRepository
) : ViewModel() {
    var nombre by mutableStateOf("")

    var uiState = MutableStateFlow(ClienteUiState())
        private set
    init {
        getListCliente()
    }
    fun getListCliente() {
        viewModelScope.launch(Dispatchers.IO) {
            clienteRepository.getList().collect{lista ->
                uiState.update {
                    it.copy(clienteList = lista)
                }
            }
        }
    }

    fun insertar() {

        val cliente = ClienteEntity(
            nombre = nombre
        )
        viewModelScope.launch(Dispatchers.IO) {
            clienteRepository.insert(cliente)
            Limpiar()
        }
    }

    private fun Limpiar() {
        nombre = ""

    }
}
