package edu.uc.jonesbr.plantplaceskotlin.dto

import com.google.gson.annotations.SerializedName

data class MatchList(@SerializedName("data") var list: List<Match>) {
}