package edu.uc.jonesbr.plantplaceskotlin

import edu.uc.jonesbr.plantplaceskotlin.dto.MatchList
import edu.uc.jonesbr.plantplaceskotlin.dto.PlantList
import edu.uc.jonesbr.plantplaceskotlin.dto.TeamList
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by ucint on 7/22/2018.
 */
interface GetPlantService {

    @GET("5de8d38a3100000f006b1479")
    fun getAllMatches() : Call<MatchList>

    @GET("5de8d40d31000074006b1487")
    fun getAllTeams() : Call<TeamList>
}