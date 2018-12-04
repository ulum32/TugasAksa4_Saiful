package aksamedia.com.tugasaksa4_saiful.model

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("idTeam")
    var teamId: String? = null,

    @SerializedName("strTeam")
    var teamName: String? = null,

    @SerializedName("strTeamBadge")
    var teamBadge: String? = null
)