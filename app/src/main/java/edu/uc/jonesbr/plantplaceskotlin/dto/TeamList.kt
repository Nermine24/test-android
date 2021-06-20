package edu.uc.jonesbr.plantplaceskotlin.dto

import com.google.gson.annotations.SerializedName

data class TeamList(@SerializedName("data") var list: List<Team>) {
}