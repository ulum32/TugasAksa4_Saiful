package aksamedia.com.tugasaksa4_saiful.model

import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("strLeague")
    var leagueName: String? = null
)