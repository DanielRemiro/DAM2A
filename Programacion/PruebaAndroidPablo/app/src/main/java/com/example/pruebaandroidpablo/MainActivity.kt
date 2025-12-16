package com.example.pruebaandroidpablo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pruebaandroidpablo.ui.theme.PruebaAndroidPabloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PruebaAndroidPabloTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var showGreeting2 by rememberSaveable { mutableStateOf(false) }

                    if (showGreeting2) {
                        Greeting2(names = listOf("Android","rrr" ,"dddd","fffff","ggggg","Pablo","de la fuente","en la calle","en el arbol","gracias","futbol"), modifier = Modifier.padding(innerPadding))
                    } else {
                        NuevaPantalla(
                            name = "Pablo",
                            modifier = Modifier.padding(innerPadding),
                            onNavigate = { showGreeting2 = true }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = rememberSaveable() { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded.value) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy
        )
    )


    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(modifier = Modifier
            .padding(24.dp)
            .padding(bottom = extraPadding.coerceAtLeast(0.dp))) {

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

    LazyColumn(modifier = modifier) {
        items(names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
fun NuevaPantalla(name: String, modifier: Modifier = Modifier, onNavigate: () -> Unit){
    Column(modifier = modifier) {
        Text(
            text = "Este es el texto"
            ,modifier = Modifier.padding(24.dp)
        )
        ElevatedButton(
            onClick = onNavigate,modifier = Modifier.padding(40.dp)

        ){
            Text("Pulsa aqui")
        }
    }
}
