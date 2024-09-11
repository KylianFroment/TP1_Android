package fr.upjv.myapplication.ui.screen

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import fr.upjv.myapplication.ui.model.ItemUi
import fr.upjv.myapplication.ui.theme.theme.DarkBluePSG
import fr.upjv.myapplication.ui.viewmodel.AndroidVersionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
) {
    val viewModel: AndroidVersionViewModel = viewModel()
    val list = viewModel.androidVersionList.collectAsState(emptyList()).value
    //val listOfResult = viewModel.androidVersionList.collectAsState().value

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
        },
        bottomBar = {
            Row (modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier.weight(1f),
                    content = {
                        Text("Add")
                    },
                    onClick = {
                        viewModel.insertPlayer()  // Call the function to add a new player
                    }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = {
                        Text("Delete")
                    },
                    onClick = {
                        viewModel.DeleteAllPlayer()  // Call the function to delete all players
                    }
                )
            }
        }
    ) { padding ->
        Column {
            Text(
                modifier = Modifier.padding(padding),
                text = "Second screen",
            )
            // Pass the list of items to MyScreen2
            MyScreen2(list)
        }
    }
}



@Composable
private fun MyScreen2(playerGroups: List<ItemUi>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
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
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )

            // Image
            Column(
                modifier = Modifier.padding(8.dp),
            ) {
                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = "https://logos-marques.com/wp-content/uploads/2020/10/PSG-Logo-1-768x480.png")
                        .build()
                )
                Image(
                    modifier = Modifier.size(128.dp),
                    painter = painter,
                    contentDescription = null,
                )
            }

            // Player groups
            LazyColumn(
                modifier = Modifier.padding(vertical = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(playerGroups) { group ->

                    when(group) {
                        is ItemUi.Header -> {
                            // Display header
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(DarkBluePSG, shape = RoundedCornerShape(15.dp))
                                    .padding(12.dp)
                            ) {
                                Text(
                                    text = group.title, // Display the header title
                                    style = MaterialTheme.typography.displaySmall,
                                    color = Color.White,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                        }

                        is ItemUi.Item -> {
                            // Display each player's info
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "${group.playerName} (${group.playerNationality})",
                                    color = Color.Black
                                )
                            }
                        }

                        is ItemUi.PlayerGroup -> TODO()
                    }
                }

                // Footer with image
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