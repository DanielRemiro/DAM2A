package com.example.proyecto1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope

// La clase implementa DefaultLifecycleObserver
class MainActivity: ComponentActivity(), DefaultLifecycleObserver {

    // 1. Este es el onCreate de la Actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super<ComponentActivity>.onCreate(savedInstanceState)
        Log.d("CicloVida", "onCreate (Activity) ejecutado")

        // 2. Registramos el observer. 'this' (la MainActivity)
        // será notificada de los cambios del ciclo de vida.
        lifecycle.addObserver(this)

        setContent {
            MaterialTheme {
                Saludo()
            }//MaterialTheme
        }//setContent
    }//onCreate

    // 3. Estos son los métodos SOBRESCRITOS de la interfaz DefaultLifecycleObserver
    // Nota que reciben un 'LifecycleOwner' como parámetro.

    override fun onCreate(owner: LifecycleOwner) {
        Log.d("CicloVida", "Creado juuuuja")
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.d("CicloVida", "Empezado juji")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d("CicloVida", "Continudado")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d("CicloVida", "Pausado joooo")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d("CicloVida", "Parado jijijija")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d("CicloVida", "Destruido jeje")
    }
}

@Composable
fun Saludo() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Text(
            text = "Ciclo de vida ",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}