/*
 *
 * Written by Muhamad Angga
 *
 */


package com.example.movieapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlaysModel (

    var nama : String? = "",
    var url : String? = ""

) : Parcelable