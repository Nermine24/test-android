package edu.uc.jonesbr.plantplaceskotlin.dto

import com.google.gson.annotations.SerializedName

data class Match(var id: Int = 0,
                 var date :String = "",
                 @SerializedName("home_team") var homeTeam :Team,
                 @SerializedName("home_team_score") var homeTeamScore : Int = 0,
                 var period : Int = 0,
                 var postseason : Boolean = false,
                 var season : Int = 0,
                 var status : String = "",
                 @SerializedName("visitor_team")var visitorTeam : Team,
                 @SerializedName("visitor_team_score") var visitor_team_score :Int = 0

                 )


