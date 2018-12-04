package aksamedia.com.tugasaksa4_saiful.presenter

import aksamedia.com.tugasaksa4_saiful.TeamDetailActivity
import aksamedia.com.tugasaksa4_saiful.api.ApiRepository
import aksamedia.com.tugasaksa4_saiful.api.EndpointApi
import aksamedia.com.tugasaksa4_saiful.contract.DetailView
import aksamedia.com.tugasaksa4_saiful.model.TeamDetail
import aksamedia.com.tugasaksa4_saiful.model.TeamDetailResponse
import com.google.gson.Gson
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPresenter(private val view: DetailView,
    private val apiRepository: ApiRepository,
    private val gson: Gson): AnkoLogger {
        fun getDetailTeam(team_detail:String) {
            view.showLoading()
            doAsync {
                val data = gson.fromJson(apiRepository
                    .lakukanRequest(EndpointApi.tampilkanTeamDetail(team_detail)),
                    TeamDetailResponse::class.java
                )

                uiThread {
                    view.hideLoading()
                    data.teams?.let{
                        view.showDetailTeam(data.teams)
                    }
                }
            }
        }
}