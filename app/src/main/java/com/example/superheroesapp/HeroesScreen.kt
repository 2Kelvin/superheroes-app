package com.example.superheroesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesRepository
import com.example.superheroesapp.ui.theme.SuperheroesAppTheme

// superhero card
@Composable
fun SuperHeroCard(hero: Hero, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier,
        // adding border-radius from our theme
        shape = MaterialTheme.shapes.medium,
        // adding custom elevation to a card
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.cardElevation)
        )
    ) {
        Row(
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.mediumPadding))
                .height(dimensionResource(id = R.dimen.cardHeightAndImageSize))
        ) {
            Column {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.superPowerRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Spacer(modifier = modifier.width(dimensionResource(R.dimen.mediumPadding)))

            Box(
                modifier = modifier
                    .height(dimensionResource(R.dimen.cardHeightAndImageSize))
                    .clip(MaterialTheme.shapes.small)
            ) {
                Image(
                    painter = painterResource(id = hero.picRes),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Preview
@Composable
fun CardLightPreview() {
    SuperheroesAppTheme(darkTheme = false) {
        SuperHeroCard(hero = HeroesRepository.heroes[0])
    }
}

@Preview
@Composable
fun CardDarkPreview() {
    SuperheroesAppTheme(darkTheme = true) {
        SuperHeroCard(hero = HeroesRepository.heroes[0])
    }
}