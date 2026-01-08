package com.example.repasocomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repasocomponentes.ui.theme.RepasoComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RepasoComponentesTheme {
                Scaffold(topBar = { BarraArriba() }) { innerPadding ->

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraArriba() {
    CenterAlignedTopAppBar(
        title = {

            Text(text = stringResource(R.string.titulo_pantalla), color = Color.White)
        },
        navigationIcon = {
            IconButton(onClick = { /* Boton que no hace nada */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back_24dp_e3e3e3_fill0_wght400_grad0_opsz24),
                    contentDescription = "Atrás",
                    tint = Color.White
                )
            }
        },
        actions = {
            Image(
                painter = painterResource(id = R.drawable.person_24dp_e3e3e3_fill0_wght400_grad0_opsz24),
                contentDescription = "Usuario",
                modifier = Modifier.padding(end = 16.dp)
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF6200EE)
        )
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContenidoPantalla(paddingValues: PaddingValues) {
    // ESTADOS: Variables para guardar lo que escribe el usuario
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }

    // Estados para el Dropdown (Lista desplegable)
    var expanded by remember { mutableStateOf(false) }
    var numeroHermanosSeleccionado by remember { mutableStateOf<Int?>(null) } // Guardamos el número
    val opcionesHermanos = listOf(1, 2, 3) // 3 representará "Más de 2" para el ejemplo

    // Estado para el texto final
    var resultado by remember { mutableStateOf("") }

    val context = LocalContext.current // Necesario para acceder a los recursos plurales

    Column(
        modifier = Modifier
            .padding(paddingValues) // Respetar el espacio de la barra de arriba
            .padding(16.dp)
            .fillMaxSize()
    ) {

        // --- CAMPO NOMBRE ---
        Text(text = stringResource(R.string.label_nombre), modifier = Modifier.padding(bottom = 4.dp))
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(stringResource(R.string.hint_nombre)) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // --- CAMPO APELLIDOS ---
        Text(text = stringResource(R.string.label_apellidos), modifier = Modifier.padding(bottom = 4.dp))
        OutlinedTextField(
            value = apellidos,
            onValueChange = { apellidos = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(stringResource(R.string.hint_apellidos)) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // --- DROPDOWN (Selector de hermanos) ---
        Text(text = stringResource(R.string.label_hermanos), modifier = Modifier.padding(bottom = 4.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                // Si es null muestra "Seleccionar", si no, muestra el texto correspondiente
                value = if (numeroHermanosSeleccionado == null) stringResource(R.string.opcion_seleccionar)
                else if (numeroHermanosSeleccionado == 3) "Más de 2 hermanos"
                else "$numeroHermanosSeleccionado " + (if(numeroHermanosSeleccionado==1) "hermano" else "hermanos"),
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.fillMaxWidth().menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                // Opción 1
                DropdownMenuItem(
                    text = { Text("1 hermano") },
                    onClick = { numeroHermanosSeleccionado = 1; expanded = false }
                )
                // Opción 2
                DropdownMenuItem(
                    text = { Text("2 hermanos") },
                    onClick = { numeroHermanosSeleccionado = 2; expanded = false }
                )
                // Opción más de 2
                DropdownMenuItem(
                    text = { Text("Más de 2 hermanos") },
                    onClick = { numeroHermanosSeleccionado = 3; expanded = false }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- TEXTO RESULTADO ---
        if (resultado.isNotEmpty()) {
            Text(
                text = resultado,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- BOTÓN MOSTRAR ---
        Button(
            onClick = {
                if (nombre.isNotEmpty() && apellidos.isNotEmpty() && numeroHermanosSeleccionado != null) {
                    // AQUÍ USAMOS EL PLURAL (Requisito clave)
                    // El 3er parámetro es el número que decide si es singular (one) o plural (other)
                    resultado = context.resources.getQuantityString(
                        R.plurals.mensaje_resultado_hermanos,
                        numeroHermanosSeleccionado!!, // Cantidad para la lógica plural
                        nombre, // %1$s
                        apellidos, // %2$s
                        numeroHermanosSeleccionado // %3$d
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
        ) {
            Text(stringResource(R.string.btn_mostrar))
        }
    }
}

