package com.example.pokemonpablo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Combate(
                Pokemon1=Pokemon("Fuego",30.0,10.0),
                Pokemon2=Pokemon("Agua",20.0,20.0)
            )
        }
    }

}

class Pokemon( val tipo: String, val ataque:Double,val defensa:Double)



fun Amplificador(Pokemon1:Pokemon, Pokemon2:Pokemon):Double{

    if(Pokemon1.tipo=="Fuego" && Pokemon2.tipo=="Agua"){
        return 0.5

    }
    if(Pokemon1.tipo=="Agua" && Pokemon2.tipo=="Fuego"){
        return 2.0
    }
    if(Pokemon1.tipo=="Fuego" && Pokemon2.tipo=="Planta"){
        return 2.0
    }
    if(Pokemon1.tipo=="Planta" && Pokemon2.tipo=="Fuego"){
        return 0.5
    }
    if(Pokemon1.tipo=="Agua" && Pokemon2.tipo=="Planta"){
        return 0.5
    }
    if(Pokemon1.tipo=="Planta" && Pokemon2.tipo=="Agua"){
        return 2.0
    }
    if(Pokemon1.tipo==Pokemon2.tipo){
        return 0.5
    }
    if(Pokemon1.tipo=="Electrico"&& Pokemon2.tipo=="Agua"){
        return 2.0
    }
    if(Pokemon1.tipo=="Agua"&& Pokemon2.tipo=="Electrico"){
        return 0.5
    }
    if(Pokemon1.tipo=="Electrico"&& Pokemon2.tipo=="Planta"){
        return 0.5
    }
    return 1.0

}
@Composable
fun Combate(Pokemon1:Pokemon, Pokemon2:Pokemon) {
    val AmplificadorPokemon=Amplificador(Pokemon1,Pokemon2)

    val Daño1=50*(Pokemon1.ataque/Pokemon2.defensa)*AmplificadorPokemon

    Text(text = "El daño total es: $Daño1")
}

