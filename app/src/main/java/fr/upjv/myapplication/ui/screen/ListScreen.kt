package fr.upjv.myapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import fr.upjv.myapplication.ui.model.ItemUi
import fr.upjv.myapplication.ui.theme.theme.DarkBluePSG

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("List Screen") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column {
        Text(
            modifier = Modifier.padding(padding),
            text = "Second screen",
        )
        MyScreen2()
        }
    }
}

val playerGroups = populateMyList()
    .groupBy { it.playerPosition } // regroupe les joueurs par position
    .map { ItemUi.PlayerGroup(position = it.key, players = it.value) } // On crée une liste de PlayerGroup


private fun populateMyList(): List<ItemUi.MyAndroidObject> {
    return listOf(
        ItemUi.MyAndroidObject(playerName = "Gianluigi Donnarumma", playerPosition = "Gardien", nationality = "Italie"),
        ItemUi.MyAndroidObject(playerName = "Keylor Navas", playerPosition = "Gardien", nationality = "Costa Rica"),
        ItemUi.MyAndroidObject(playerName = "Arnau Tenas", playerPosition = "Gardien", nationality = "Espagne"),
        ItemUi.MyAndroidObject(playerName = "Alexandre Letellier", playerPosition = "Gardien", nationality = "France"),

        ItemUi.MyAndroidObject(playerName = "Achraf Hakimi", playerPosition = "Défenseur", nationality = "Maroc"),
        ItemUi.MyAndroidObject(playerName = "Milan Škriniar", playerPosition = "Défenseur", nationality = "Slovaquie"),
        ItemUi.MyAndroidObject(playerName = "Marquinhos", playerPosition = "Défenseur", nationality = "Brésil"),
        ItemUi.MyAndroidObject(playerName = "Lucas Hernandez", playerPosition = "Défenseur", nationality = "France"),
        ItemUi.MyAndroidObject(playerName = "Presnel Kimpembe", playerPosition = "Défenseur", nationality = "France"),
        ItemUi.MyAndroidObject(playerName = "Danilo Pereira", playerPosition = "Défenseur", nationality = "Portugal"),
        ItemUi.MyAndroidObject(playerName = "Nordi Mukiele", playerPosition = "Défenseur", nationality = "France"),
        ItemUi.MyAndroidObject(playerName = "Layvin Kurzawa", playerPosition = "Défenseur", nationality = "France"),
        ItemUi.MyAndroidObject(playerName = "Juan Bernat", playerPosition = "Défenseur", nationality = "Espagne"),

        ItemUi.MyAndroidObject(playerName = "Manuel Ugarte", playerPosition = "Milieu", nationality = "Uruguay"),
        ItemUi.MyAndroidObject(playerName = "Vitinha", playerPosition = "Milieu", nationality = "Portugal"),
        ItemUi.MyAndroidObject(playerName = "Warren Zaïre-Emery", playerPosition = "Milieu", nationality = "France"),
        ItemUi.MyAndroidObject(playerName = "Carlos Soler", playerPosition = "Milieu", nationality = "Espagne"),
        ItemUi.MyAndroidObject(playerName = "Fabián Ruiz", playerPosition = "Milieu", nationality = "Espagne"),
        ItemUi.MyAndroidObject(playerName = "Cher Ndour", playerPosition = "Milieu", nationality = "Italie"),
        ItemUi.MyAndroidObject(playerName = "Kang-In Lee", playerPosition = "Milieu", nationality = "Corée du Sud"),

        ItemUi.MyAndroidObject(playerName = "Kylian Mbappé", playerPosition = "Attaquant", nationality = "France"),
        ItemUi.MyAndroidObject(playerName = "Ousmane Dembélé", playerPosition = "Attaquant", nationality = "France"),
        ItemUi.MyAndroidObject(playerName = "Gonçalo Ramos", playerPosition = "Attaquant", nationality = "Portugal"),
        ItemUi.MyAndroidObject(playerName = "Marco Asensio", playerPosition = "Attaquant", nationality = "Espagne"),
        ItemUi.MyAndroidObject(playerName = "Randal Kolo Muani", playerPosition = "Attaquant", nationality = "France"),
        ItemUi.MyAndroidObject(playerName = "Bradley Barcola", playerPosition = "Attaquant", nationality = "France")
    )
}


@Composable
private fun MyScreen2() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        val playerGroups = populateMyList()
            .groupBy { it.playerPosition }
            .map { ItemUi.PlayerGroup(position = it.key, players = it.value) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Header
            Text(
                text = "Effectif PSG 2023/24",
                modifier = Modifier.padding(8.dp),
                fontSize = 24.sp, // Définit une taille de texte spécifique
                fontWeight = FontWeight.Bold, // Met le texte en gras
            )


            // Image
            Column(
                modifier = Modifier
                    .padding(8.dp),
            ) {
                val painter = rememberAsyncImagePainter(
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(data = "https://logos-marques.com/wp-content/uploads/2020/10/PSG-Logo-1-768x480.png")
                        .build()
                )
                Image(
                    modifier = Modifier.size(128.dp),
                    painter = painter,
                    contentDescription = null,
                )
            }

            // Liste des groupes
            LazyColumn(
                modifier = Modifier.padding(vertical = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(playerGroups) { group ->
                    // Affichage du poste pour chaque groupe
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(DarkBluePSG, shape = RoundedCornerShape(15.dp))
                            .padding(12.dp)
                    ) {
                        Text(
                            text = group.position, // Affiche la position (Gardien, Défenseur, etc.)
                            style = MaterialTheme.typography.displaySmall,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    // Affichage des joueurs de chaque groupe
                    group.players.forEach { player ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "${player.playerName} (${player.nationality})",
                                color = Color.Black

                            )
                        }
                    }
                }

                // Footer avec une image
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        val painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data("https://img-4.linternaute.com/iV6f6zzu97ztL5jqrtfwEYFCqcg=/1500x/smart/e689eb9389594dc6ac57b35a833adbf8/ccmcms-linternaute/60110040.jpg")
                                .build()
                        )

                        Image(
                            painter = painter,
                            contentDescription = "Footer Image",
                            modifier = Modifier.size(400.dp)
                        )
                    }
                }

            }
        }
    }
}
