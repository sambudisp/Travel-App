package com.sambudisp.travelapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DestinationModel(
    val image : Int,
    val name : String,
    val detail : String,
    val price : String,
    val rating : String
) : Parcelable