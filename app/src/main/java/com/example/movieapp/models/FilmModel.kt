/*
 *
 * Written by Muhamad Angga
 *
 */

package com.example.movieapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmModel (

    var desc : String? = "",
    var director : String? = "",
    var genre : String? = "",
    var judul : String? = "",
    var poster : String? = "",
    var rating : String? = ""

) : Parcelable