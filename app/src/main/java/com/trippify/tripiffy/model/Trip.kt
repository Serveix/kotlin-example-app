package com.trippify.tripiffy.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.Serializable
import java.net.URL

data class Trip(val title: String,
           val description: String,
           val imageUrl: String,
           val environment: String,
           val mainCategory: String) : Serializable {

    fun getImage(): Bitmap? {
        return BitmapFactory.decodeStream(URL(imageUrl).openConnection().getInputStream())
    }
}