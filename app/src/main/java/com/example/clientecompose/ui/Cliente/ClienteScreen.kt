package com.example.clientecompose.ui.Cliente

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.twotone.AttachMoney
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material.icons.twotone.Description
import androidx.compose.material.icons.twotone.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.clientecompose.data.local.entity.ClienteEntity

@Composable
fun ClienteScreen(viewModel: ClienteViewModel = hiltViewModel()) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Registro De Clientes",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.padding(15.dp))
        Clientes(viewModel)

        Spacer(modifier = Modifier.padding(18.dp))
        Text(
            text = "Lista de Clientes",
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.padding(10.dp))
        val uiState by viewModel.uiState.collectAsState()
        ClienteListScreen(uiState.clienteList)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun Clientes(viewModel: ClienteViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = viewModel.nombre,
            onValueChange = { viewModel.nombre = it },
            label = { Text("Nombre") }
        )
    }

    Spacer(modifier = Modifier.padding(14.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {

            Spacer(modifier = Modifier.padding(20.dp))
            Box() {
                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .size(60.dp, 50.dp),
                    containerColor = Color.White,
                    text = { Text("Guardar") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Save,
                            contentDescription = "Save",
                            tint = Color.Green
                        )
                    },
                    onClick = {
                        viewModel.insertar()
                    }
                )
            }
        }
    }
}

@Composable
private fun ClienteListScreen(clienteList: List<ClienteEntity>) {
    LazyColumn {
        items(clienteList) { cliente ->
            ClienteRow(cliente)
        }
    }
}

@Composable
private fun ClienteRow(cliente: ClienteEntity) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.CenterStart)
        ) {
            Text(
                text = cliente.nombre,
                fontSize = 24.sp,
                modifier = Modifier.wrapContentSize(Alignment.CenterStart)
            )
        }
    }
}
