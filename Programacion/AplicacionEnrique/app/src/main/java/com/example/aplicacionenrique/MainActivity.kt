package com.example.aplicacionenrique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aplicacionenrique.ui.theme.AplicacionEnriqueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         AplicacionEnriqueTheme() {
            Scaffold(topBar = {EjemploRecursos()}) { innerPadding ->

                Column(modifier = Modifier.padding(innerPadding)) {
                    Text(text = "Contenido principal")
                }

            }
         }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploRecursos(){

    CenterAlignedTopAppBar(title =  {
        Row {
            Text(text = stringResource(R.string.titulo_app))
            Image(
                painter = painterResource(R.drawable.settings_accessibility_24dp_e3e3e3_fill0_wght400_grad0_opsz24),
                contentDescription = "Icono propio"
            )
        }
    })

}

@Preview(showBackground = true)
@Composable
fun EjemploRecursosPreview() {

        EjemploRecursos()

}