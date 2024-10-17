package fr.upjv.myapplication.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    onButtonClick: () -> Unit,
    onButton2Click: () -> Unit,
    onButton3Click: () -> Unit,


    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Centrer le contenu horizontalement
        verticalArrangement = Arrangement.Center // Centrer le contenu verticalement
    ) {
        Text("Froment Kylian")


        Button(
            onClick = { onButtonClick() },
            modifier = Modifier
                .padding(16.dp) // Ajout d'un padding autour du bouton
        ) {
            Text("Go to list screen")
        }


        Button(
            content = {
                Text("go to quote screen")
            },
            onClick = { onButton2Click() }
        )

        Button(
            content = {
                Text("go to random player screen")
            },
            onClick = { onButton3Click() }
        )

    }
}

