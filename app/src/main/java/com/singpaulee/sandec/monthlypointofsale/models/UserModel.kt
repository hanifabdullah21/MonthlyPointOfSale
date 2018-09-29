package com.singpaulee.sandec.monthlypointofsale.models
import com.google.gson.annotations.SerializedName

data class UserModel(
        @SerializedName("id") var id: String,
        @SerializedName("nama") var nama: String,
        @SerializedName("username") var username: String
)