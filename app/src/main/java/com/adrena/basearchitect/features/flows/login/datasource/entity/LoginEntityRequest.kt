package com.adrena.basearchitect.features.flows.login.datasource.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class LoginEntityRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
): Parcelable