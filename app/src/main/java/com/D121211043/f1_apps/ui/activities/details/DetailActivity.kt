package com.D121211043.f1_apps.ui.activities.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import com.D121211043.f1_apps.data.models.CircuitItem
import com.D121211043.f1_apps.ui.theme.F1appsTheme

class DetailActivity : ComponentActivity() {

    private var selectedCircuit: CircuitItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedCircuit = intent.getParcelableExtra("CIRCUIT")
        setContent {
            F1appsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen()
                }
            }
        }
    }

    @Composable
    private fun DetailScreen() {
        LazyColumn {
            item {
                Text(text = selectedCircuit?.meeting_official_name.toString())
                Text(text = selectedCircuit?.location.toString())
            }
        }
    }

}