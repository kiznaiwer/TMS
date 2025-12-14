package com.example.tms.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserMessage(
    val text: String,
    val timeStamp: Long
): Parcelable