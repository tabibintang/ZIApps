package co.id.zeelandia.ziapps.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    @field:SerializedName("worker_id")
    val workerId: String? = null,
    val email: String? = null,
    val name: String? = null,
    val token: String? = null
) : Parcelable