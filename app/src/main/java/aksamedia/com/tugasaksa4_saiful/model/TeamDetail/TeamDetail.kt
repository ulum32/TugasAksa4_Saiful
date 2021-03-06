package aksamedia.com.tugasaksa4_saiful.model.TeamDetail

import com.google.gson.annotations.SerializedName

data class TeamDetail(
    @SerializedName("idTeam")
    var teamId: String? = null,

    @SerializedName("strTeam")
    var teamName: String? = null,

    @SerializedName("strDescriptionEN")
    var teamDesc: String? = null,

    @SerializedName("strTeamBadge")
    var teamBadge: String? = null
)