package aksamedia.com.tugasaksa4_saiful.model

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("idPlayer")
    var playerId: String? = null,

    @SerializedName("strPlayer")
    var playerName: String? = null,

    @SerializedName("strThumb")
    var playerPhoto: String? = null
)