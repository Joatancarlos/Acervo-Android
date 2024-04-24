package com.example.anfbios.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.anfbios.models.AnfibioInfo
import com.example.anfbios.ui.theme.AnfíbiosTheme

@Composable
fun HomeScreen() {
    val viewModel: AmphibiansViewModel = viewModel(factory = AmphibiansViewModel.Factory)
    val amphibiansUiState = viewModel.amphibiansUiState
    Scaffold { innerPadding ->
        Column {
            when(amphibiansUiState) {
                is AmphibiansUiState.Loading -> LoadingScreen()
                is AmphibiansUiState.Success -> SuccessScreen(
                    listInfo = amphibiansUiState.anfibios,
                    contentPadding = innerPadding
                )
                is AmphibiansUiState.Error -> ErrorScreen(
                    retryAction = viewModel::getAmphibians
                )
            }
        }
    }
}

@Composable
fun LoadingScreen() {
    Text(text = "Carregando...")
}

@Composable
fun SuccessScreen(
    listInfo: List<AnfibioInfo>,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn {
        items(items = listInfo, key = { info -> info.name }) {it ->
            Card {
                Text(text = it.name)
                Spacer(modifier = Modifier.height(16.dp))
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(it.imgSrc)
                        .crossfade(true)
                        .build(),
                    contentDescription = it.description
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = it.description)
            }
        }
    }
}

@Composable
fun ErrorScreen(
    retryAction: () -> Unit
) {
    Column {
        Text(text = "Deu ruim. F")
        Button(onClick = retryAction) {
            Text(text = "Retry")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewAnfibioApp() {
    AnfíbiosTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewErrorScreen() {
    AnfíbiosTheme {
        ErrorScreen(
            retryAction ={}
        )
    }
}