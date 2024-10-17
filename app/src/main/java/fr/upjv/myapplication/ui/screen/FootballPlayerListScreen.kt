package fr.upjv.myapplication.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import fr.upjv.myapplication.ui.model.FootballPlayerItemUi
import fr.upjv.myapplication.ui.viewmodel.FootballPlayerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FootballPlayerListScreen() {
    // Assurez-vous que vous utilisez le FootballPlayerViewModel
    val viewModel: FootballPlayerViewModel = viewModel()
    val players = viewModel.players.collectAsState(emptyList()).value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Football Player List") },

            )
        },
        bottomBar = {
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text("Add Player") },
                    onClick = { viewModel.fetchRandomPlayer() }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text("Delete All") },
                    onClick = { viewModel.deleteAllPlayers() }
                )
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(players) { player ->
                Text(text = "${player.name} - ${player.position} - ${player.nationality}")
            }
        }
    }
}
