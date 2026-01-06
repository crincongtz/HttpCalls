package dev.alexrincon.httpcall.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData (
    val userId: Int,
    val title: String,
    val completed: Boolean
): Parcelable
