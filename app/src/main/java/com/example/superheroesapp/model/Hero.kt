package com.example.superheroesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superheroesapp.R

// object structure of each hero
data class Hero(
    @StringRes val nameRes: Int,
    @StringRes val superPowerRes: Int,
    @DrawableRes val picRes: Int
)

object HeroesRepository { // one time object
    val heroes = listOf( // array of heroes
        Hero(
            nameRes = R.string.hero1,
            superPowerRes = R.string.description1,
            picRes = R.drawable.android_superhero1
        ),
        Hero(
            nameRes = R.string.hero2,
            superPowerRes = R.string.description2,
            picRes = R.drawable.android_superhero2
        ),
        Hero(
            nameRes = R.string.hero3,
            superPowerRes = R.string.description3,
            picRes = R.drawable.android_superhero3
        ),
        Hero(
            nameRes = R.string.hero4,
            superPowerRes = R.string.description4,
            picRes = R.drawable.android_superhero4
        ),
        Hero(
            nameRes = R.string.hero5,
            superPowerRes = R.string.description5,
            picRes = R.drawable.android_superhero5
        ),
        Hero(
            nameRes = R.string.hero6,
            superPowerRes = R.string.description6,
            picRes = R.drawable.android_superhero6
        )
    )
}