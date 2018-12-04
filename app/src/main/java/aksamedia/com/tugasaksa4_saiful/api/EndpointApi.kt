package aksamedia.com.tugasaksa4_saiful.api

import aksamedia.com.tugasaksa4_saiful.BuildConfig

object EndpointApi {
    fun tampilkanTim(berdasarkanliga: String?): String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.API_KEY}/search_all_teams.php?l=" + berdasarkanliga
    }

    fun tampilkanListLiga():String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.API_KEY}/all_leagues.php"
    }

    fun tampilkanTeamDetail(idTeam:String):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.API_KEY}/lookupteam.php?id="+ idTeam
    }

    fun tampilkanPlayer(idTeam:String):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.API_KEY}/lookup_all_players.php?id="+ idTeam
    }

}