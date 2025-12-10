package com.example.pruebaandroidpablo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebaandroidpablo.ui.theme.PruebaAndroidPabloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PruebaAndroidPabloTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NuevaPantalla(
                        name = "Pablo",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding=if(expanded.value)48.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp).padding(bottom = extraPadding)) {

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Hello",
                    color = Color.Red
                )

                Text(
                    text = "$name!",
                    color = Color.White
                )
            }

            ElevatedButton(
                onClick = { expanded.value=!expanded.value }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black
                )
            ) {
                Text(if(!expanded.value)"Muestra mas" else "Muestra menos")
            }
        }
    }
}

@Composable
fun Greeting2(names: List<String>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
fun NuevaPantalla(name: String, modifier: Modifier = Modifier){

    Text(
        text = "Este es el texto"
        ,modifier = Modifier.padding(24.dp)
    )
    ElevatedButton(
        onClick = { /*TODO*/ },modifier = Modifier.padding(40.dp)

    ){
        Text("Pulsa aqui")
    }

}
