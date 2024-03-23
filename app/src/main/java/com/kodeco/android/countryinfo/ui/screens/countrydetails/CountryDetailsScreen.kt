package com.kodeco.android.countryinfo.ui.screens.countrydetails

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kodeco.android.countryinfo.models.Country
import com.kodeco.android.countryinfo.sample.sampleCountry

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryDetailsScreen(
    viewModel: CountryDetailsViewModel,
    onNavigateUp: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = viewModel.getCountry.value!!.commonName)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onNavigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
            )
        },
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            item { Text(text = "Capital: ${viewModel.getCountry.value!!.mainCapital}") }
            item { Text(text = "Population: ${viewModel.getCountry.value!!.population}") }
            item { Text(text = "Area: ${viewModel.getCountry.value!!.area}") }
            item {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(viewModel.getCountry.value!!.flagUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Flag",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.border(1.dp, color = MaterialTheme.colorScheme.primary)
                )
            }
        }
    }
}

@Preview
@Composable
fun CountryDetailsScreenPreview() {
//    CountryDetailsScreen(
//        country = sampleCountry,
//        onNavigateUp = {},
//    )
}
