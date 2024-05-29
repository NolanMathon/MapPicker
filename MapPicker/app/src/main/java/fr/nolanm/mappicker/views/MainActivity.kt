package fr.nolanm.mappicker.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.nolanm.mappicker.viewsmodels.MainActivityViewModel
import fr.nolanm.mappicker.ui.theme.MapPickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MapPickerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                            modifier = Modifier.padding(innerPadding),
                            viewModel = MainActivityViewModel()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, viewModel: MainActivityViewModel) {
    var home by remember { mutableStateOf("") }
    var away by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .imePadding()
            .fillMaxSize()
            .paint(
                painterResource(id = viewModel.mainBackgroundId),
                contentScale = ContentScale.FillBounds
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = home,
            onValueChange = { newText -> home = newText},
            label = { Text(text = "Home") },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp),
        )

        OutlinedTextField(
            value = away,
            onValueChange = { newText -> away = newText},
            label = { Text(text = "Away") },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )
        
        OutlinedButton(
            onClick = {
                /*TODO :
                    - Sauvegarder les données des inputs
                    - Naviguer vers une prochaine page
            */
            }
        ) {
            Text(text = "Valider")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MapPickerTheme {
        Greeting(viewModel = MainActivityViewModel())
    }
}