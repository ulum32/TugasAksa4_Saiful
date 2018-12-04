package aksamedia.com.tugasaksa4_saiful.contract

import aksamedia.com.tugasaksa4_saiful.model.Player.Player
import aksamedia.com.tugasaksa4_saiful.model.TeamDetail.TeamDetail

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun showDetailTeam(data: List<TeamDetail>)
    fun showPlayer(data: List<Player>)
}