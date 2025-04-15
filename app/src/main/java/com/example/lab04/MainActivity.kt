package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme {
                PantallaPrincipal()
            }
        }
    }
}

@Composable
fun PantallaPrincipal() {
    var texto by remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { texto = "" }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)) {

            // OutlinedTextField
            OutlinedTextField(
                value = texto,
                onValueChange = { texto = it },
                label = { Text("Ingresa tu nombre") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), // Agregado padding
                textStyle = TextStyle(fontSize = 18.sp, color = Color.Blue), // Cambiar el color y tamaño de texto
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Green, // Borde verde cuando está enfocado
                    unfocusedBorderColor = Color.Gray // Borde gris cuando no está enfocado
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // LazyColumn
            val elementos = listOf("Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4")
            LazyColumn {
                items(elementos) { item ->
                    Text(
                        text = "$item - $texto",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantalla() {
    Lab04Theme {
        PantallaPrincipal()
    }
}
