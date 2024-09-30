package com.example.indkbsliste

import android.content.ClipData.Item
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Visibility
import com.example.indkbsliste.ui.theme.IndkøbslisteTheme
import com.google.android.gms.analytics.ecommerce.Product
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndkøbslisteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        val configuration = LocalConfiguration.current

                        when (configuration.orientation) {
                            Configuration.ORIENTATION_PORTRAIT -> {

                            }

                            Configuration.ORIENTATION_LANDSCAPE ->{

                            }

                            else -> {

                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun ProductsScreen(modifier: Modifier = Modifier)
{
    val Items = remember { mutableStateListOf<String>() }
    var Item by remember { mutableStateOf("") }


    Column  (modifier = modifier.padding(10.dp)) {
        Text(text = "Shoping List", style = MaterialTheme.typography.headlineLarge)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            OutlinedTextField(
                value = Item,
                onValueChange = { Item = it },
                // https://medium.com/@GkhKaya00/exploring-keyboard-types-in-kotlin-jetpack-compose-ca1f617e1109
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

                label = { Text("Enter a word") }
            )
            Button(onClick = {
                Items.add(Item)
            }) {
                Text("+")
            }




        }
        LazyColumn(modifier = modifier) {
            items(Items) {item ->
                ItemsCard(item = item, onDelete = {Items.remove(item)})
            }
        }

    }


}

@Composable
fun ItemsCard(
    item: String,
    onClick: (Item) -> Unit = {},
    modifier: Modifier = Modifier,
    onDelete: () -> Unit = {}
){
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(5.dp)
    ) {
        Row(modifier = Modifier.padding(2.dp), verticalAlignment = CenterVertically) {
            Text(text = item)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { onDelete() }) {
                Icon(Icons.Default.Delete, contentDescription = "Delete")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IndkøbslisteTheme {
        ProductsScreen()
    }
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun caculator(modifier: Modifier = Modifier)
{
    Column ( modifier = modifier
        .padding(10.dp)
        .fillMaxSize()
    ) {
        OutlinedTextField( modifier = Modifier.fillMaxWidth() ,value = "", onValueChange = {  }, label = { Text("Enter a word") })
        Row(
        ) {

            Button(modifier = Modifier.weight(1f).height(100.dp), onClick = {  }) { Text("7") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("8") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("9") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("+") }
        }
        Row(
        ) {
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("4") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("5") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("6") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("-") }
        }
        Row(
        ) {
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("1") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("2") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("3") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("/") }
        }
        Row(
        ) {
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("0") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text(".") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("=") }
            Button(modifier = Modifier.weight(1f).height(100.dp),onClick = {  }) { Text("*") }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    IndkøbslisteTheme {
        caculator()
    }
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Call(modifier: Modifier = Modifier) {
    // Define common button modifiers
    val buttonModifier = Modifier

        .height(60.dp) // Set a fixed height for buttons
        .padding(4.dp) // Optional: Add padding around buttons

    Column(
        modifier = modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Enter a word") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp)) // Add spacing between text field and buttons
        Column(modifier = Modifier.weight(1f)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(modifier = buttonModifier, onClick = { }) { Text("7") }
                Button(modifier = buttonModifier, onClick = { }) { Text("8") }
                Button(modifier = buttonModifier, onClick = { }) { Text("9") }
                Button(modifier = buttonModifier, onClick = { }) { Text("+") }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(modifier = buttonModifier, onClick = { }) { Text("4") }
                Button(modifier = buttonModifier, onClick = { }) { Text("5") }
                Button(modifier = buttonModifier, onClick = { }) { Text("6") }
                Button(modifier = buttonModifier, onClick = { }) { Text("-") }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(modifier = buttonModifier, onClick = { }) { Text("1") }
                Button(modifier = buttonModifier, onClick = { }) { Text("2") }
                Button(modifier = buttonModifier, onClick = { }) { Text("3") }
                Button(modifier = buttonModifier, onClick = { }) { Text("/") }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(modifier = buttonModifier, onClick = { }) { Text("0") }
                Button(modifier = buttonModifier, onClick = { }) { Text(".") }
                Button(modifier = buttonModifier, onClick = { }) { Text("=") }
                Button(modifier = buttonModifier, onClick = { }) { Text("*") }
            }
        }
    }
}
@Preview
@Composable
fun CalPreview() {
    IndkøbslisteTheme {
        Call()
    }
}