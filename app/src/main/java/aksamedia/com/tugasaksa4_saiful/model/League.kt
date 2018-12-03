package aksamedia.com.tugasaksa4_saiful.model

import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("idTeam")
    var leagueId: String? = null,

    @SerializedName("strTeam")
    var leagueName: String? = null
)