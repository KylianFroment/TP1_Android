import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.upjv.myapplication.ui.viewmodel.ChuckNorrisViewModel

@Composable
fun QuoteScreen() {
    val viewModel: ChuckNorrisViewModel = viewModel()
    val list = viewModel.quote.collectAsState(emptyList()).value

    LazyColumn(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Correct Alignment import
    ) {
        items(list) { item ->
            Text(text = "Quote: ${item.quote}")
        }
        item {
            // Spacer for spacing between buttons
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text("Add") },
                    onClick = { viewModel.insertNewQuote() }
                )
                Spacer(modifier = Modifier.width(16.dp)) // Space between buttons
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text("Delete") },
                    onClick = { viewModel.deleteAllQuote() }
                )
            }
        }
    }
}
