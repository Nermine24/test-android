package edu.uc.jonesbr.plantplaceskotlin.dto

import com.google.gson.annotations.SerializedName


data class Team(    var id: Int = 0,
                    var abbreviation : String = "",
                    var city : String = "",
                    var conference : String = "",
                    var division : String = "" ,
                    var full_name : String = "",
                    var name : String = ""
                    ) {
        constructor() : this(0, "", "", "","","","")

}




