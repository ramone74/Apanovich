package com.example.mymovieapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Movie (
    @StringRes val stringResourceIdTitle: Int,
    @StringRes val stringResourceIdDescr: Int,
    @StringRes val stringResourceIdGenre: Int,
    @StringRes val stringResourceIdCountry: Int,
    @DrawableRes val imageResourceId: Int
)