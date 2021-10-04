package com.adrena.basearchitect.features.flows.login.datasource.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class LoginEntityResponse (
    @SerializedName("data") val data: Data
): Parcelable

@Parcelize
class Data (
    @SerializedName("user") val user: User
): Parcelable

@Parcelize
class User (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("country") val country: String,
    @SerializedName("birthdate") val birthdate: String,
    @SerializedName("status") val status: String,
    @SerializedName("role") val role: String,
): Parcelable
