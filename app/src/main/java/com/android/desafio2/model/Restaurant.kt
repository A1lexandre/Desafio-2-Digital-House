package com.android.desafio2.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.android.parcel.Parcelize

@Parcelize
class Restaurant(var photoUri: String, var name: String,
                 var address: String, var closeHour: Int, var mainCourseList: List<MainCourse>): Parcelable {
}