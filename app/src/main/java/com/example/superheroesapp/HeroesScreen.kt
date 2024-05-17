package com.example.superheroesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.superheroesapp.model.Hero

// superhero card
@Composable
fun SuperHeroCard(hero: Hero, modifier: Modifier = Modifier) {
    ElevatedCard(modifier = modifier) {
        Row(modifier = modifier.padding(dimensionResource(id = R.dimen.mediumPadding))) {
            Column {
                Text(
                    text = stringResource(id = hero.nameRes)
                )
                Text(
                    text = stringResource(id = hero.superPowerRes)
                )
            }

            Image(
                painter = painterResource(id = hero.picRes),
                contentDescription = null
            )
        }
    }
}