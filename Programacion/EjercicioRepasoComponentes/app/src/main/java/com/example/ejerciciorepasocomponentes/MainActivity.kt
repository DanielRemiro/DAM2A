package com.example.ejerciciorepasocomponentes
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ejerciciorepasocomponentes.ui.theme.EjercicioRepasoComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EjercicioRepasoComponentesTheme {
                Scaffold(topBar = { BarraArriba() }) { innerPadding ->

                    Column (modifier = Modifier.padding(innerPadding)){
                        PantallaPrincipal()
                    }

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

@Composable
fun PantallaPrincipal(){

    OutlinedTextField(value=stringResource(R.string.label_nombre), onValueChange = {/**/})
    OutlinedTextField(value=stringResource(R.string.label_apellidos), onValueChange = {/**/})

    ElevatedButton(onClick = { /*TODO*/ }){
        Text(text = stringResource(R.string.btn_mostrar))
    }



}
