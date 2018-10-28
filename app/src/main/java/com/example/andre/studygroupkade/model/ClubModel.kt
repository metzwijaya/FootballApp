package com.example.andre.studygroupkade.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClubModel(val name: String = "", val image: Int = 0, val desc: String = "") : Parcelable

@Parcelize
data class TeamModel(
    @SerializedName("idTeam")
    val teamId : String = "",

    @SerializedName("strTeam")
    val teamName : String = "",

    @SerializedName("strTeamBadge")
    val teamBadge : String = ""
) : Parcelable

data class TeamResponse(
    @SerializedName("teams")
    val teams : List<TeamModel> = arrayListOf()
)