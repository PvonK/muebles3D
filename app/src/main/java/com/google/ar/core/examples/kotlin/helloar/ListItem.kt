package com.google.ar.core.examples.kotlin.helloar

import kotlinx.parcelize.Parcelize
import android.media.Image
import android.os.Parcelable

@Parcelize
data class ListItem(
    val name: String,
    val description: String,
    val imagePath: String,
    var MeshPath: String,
    var PbrTexturePath: String,
    var AlbedoTexturePath: String,
    var AlbedoInstantPlacementTexturePath: String,
    ): Parcelable



