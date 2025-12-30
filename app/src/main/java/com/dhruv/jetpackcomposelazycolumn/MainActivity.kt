package com.dhruv.jetpackcomposelazycolumn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dhruv.jetpackcomposelazycolumn.ui.list.ListViewCell
import com.dhruv.jetpackcomposelazycolumn.ui.list.MainListViewModel
import com.dhruv.jetpackcomposelazycolumn.ui.theme.LazyColumnComposeLazyColumnTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyColumnComposeLazyColumnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()) {
                    renderList()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun renderList(viewModel: MainListViewModel = viewModel()) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("JetPackCompose LazyColumn")
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(viewModel.pokemonList) { it ->
                ListViewCell(
                    it,
                    onPokemonClick = { it ->
                        Log.i("Dhruv", "${it.name} Clicked")
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    LazyColumnComposeLazyColumnTheme {
        renderList()
    }
}