package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroesapp.model.HeroesRepository
import com.example.superheroesapp.ui.theme.SuperheroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { AppCenterTopBar() } // my top bar
                ) { innerPadding ->
                    AllSuperHeroes(
                        allHeroes = HeroesRepository.heroes,
                        contentPd = innerPadding
                    )
                }
            }
        }
    }
}


// center top bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppCenterTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.sups),
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier.wrapContentSize(Alignment.Center)
    )
}

@Preview
@Composable
fun AppLightPreview() {
    SuperheroesAppTheme(darkTheme = false) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { AppCenterTopBar() } // my top bar
        ) { innerPadding ->
            AllSuperHeroes(
                allHeroes = HeroesRepository.heroes,
                contentPd = innerPadding
            )
        }
    }
}

@Preview
@Composable
fun AppDarkPreview() {
    SuperheroesAppTheme(darkTheme = true) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { AppCenterTopBar() } // my top bar
        ) { innerPadding ->
            AllSuperHeroes(
                allHeroes = HeroesRepository.heroes,
                contentPd = innerPadding
            )
        }
    }
}