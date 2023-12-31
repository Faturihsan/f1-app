package com.D121211043.f1_apps.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.D121211043.f1_apps.data.models.CircuitItem
import com.D121211043.f1_apps.ui.activities.details.DetailActivity
import com.D121211043.f1_apps.ui.theme.F1appsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            F1appsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "Circuit List of Formula 1") },
                            )
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = {}) {
                                Icon(Icons.Default.Add, contentDescription = "Add")
                            }
                        }
                    ) {
                        Column(modifier = Modifier.padding(it)) {
                            val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                            ListCircuitScreen(mainViewModel.mainUiState)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ListCircuitScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when(mainUiState) {
            is MainUiState.Success -> ListCircuit(mainUiState.circuit)
            is MainUiState.Error -> ErrorText()
            is MainUiState.Loading -> LoadingBar()
        }
    }

    @Composable
    private fun ErrorText() {
        Text(text = "ERROR")
    }

    @Composable
    fun LoadingBar() {
        Text(text = "SEDANG LOADING")
    }

    @Composable
    private fun ListCircuit(circuits: List<CircuitItem>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(circuits) { circuit ->
                CircuitCard(circuit = circuit)
            }
        }
    }

    @Composable
    private fun CircuitCard(circuit: CircuitItem, modifier: Modifier = Modifier) {
        Card(modifier = Modifier.clickable {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("CIRCUIT", circuit)
            startActivity(intent)
        }) {
            Column {
                Text(text = circuit.meeting_name ?: "Ini Circuit")
            }
        }
    }

}