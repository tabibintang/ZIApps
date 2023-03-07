package co.id.zeelandia.ziapps.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BasicResponse (
    val success: Boolean,
    val message: String? = null
) : Parcelable