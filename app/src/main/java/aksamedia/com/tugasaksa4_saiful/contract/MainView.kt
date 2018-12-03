package aksamedia.com.tugasaksa4_saiful.contract

import aksamedia.com.tugasaksa4_saiful.model.League
import aksamedia.com.tugasaksa4_saiful.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
    fun showListLiga(data: List<League>)
}