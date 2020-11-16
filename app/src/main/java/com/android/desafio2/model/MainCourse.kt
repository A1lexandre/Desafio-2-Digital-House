package com.android.desafio2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MainCourse(var photoUri: String, var name: String, var description: String) : Parcelable {
}