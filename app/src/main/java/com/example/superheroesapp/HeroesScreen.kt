package com.example.superheroesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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

// all superheroes in a LazyColumn list
@Composable
fun AllSuperHeroes(
    allHeroes: List<Hero>,
    modifier: Modifier = Modifier,
    contentPd: PaddingValues = PaddingValues(dimensionResource(R.dimen.mediumPadding))
) {
    LazyColumn(
        modifier = modifier.padding(dimensionResource(id = R.dimen.mediumPadding)),
        contentPadding = contentPd,
        // vertical space between each hero card
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.mediumPadding))
    ) {
        items(allHeroes) {
            SuperHeroCard(hero = it)
        }
    }
}

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
                .padding(all = dimensionResource(id = R.dimen.mediumPadding))
                // setting a minimum height the row layout can have
                // row can have a >= minimum height depending on the height of it's children
                .sizeIn(minHeight = dimensionResource(id = R.dimen.cardHeightAndImageSize))
        ) {
            Column(modifier = modifier.weight(1f)) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.superPowerRes),
                    style = MaterialTheme.typography.bodyLarge,
//                    overflow = TextOverflow.Visible
                )
            }

            Spacer(modifier = modifier.width(dimensionResource(R.dimen.mediumPadding)))

            Box(
                modifier = modifier
                    .size(dimensionResource(R.dimen.cardHeightAndImageSize))
                    .clip(MaterialTheme.shapes.small)
            ) {
                Image(
                    painter = painterResource(id = hero.picRes),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Preview
@Composable
fun AllCardLightPreview() {
    SuperheroesAppTheme(darkTheme = false) {
        AllSuperHeroes(allHeroes = HeroesRepository.heroes)

    }
}

@Preview
@Composable
fun AllCardDarkPreview() {
    SuperheroesAppTheme(darkTheme = true) {
        AllSuperHeroes(allHeroes = HeroesRepository.heroes)
    }
}