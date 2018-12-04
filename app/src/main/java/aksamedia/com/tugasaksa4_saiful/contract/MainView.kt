package aksamedia.com.tugasaksa4_saiful.contract

import aksamedia.com.tugasaksa4_saiful.model.League.League
import aksamedia.com.tugasaksa4_saiful.model.Team.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
    fun showListLiga(data: List<League>)
}