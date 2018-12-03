package aksamedia.com.tugasaksa4_saiful.presenter

import aksamedia.com.tugasaksa4_saiful.api.ApiRepository
import aksamedia.com.tugasaksa4_saiful.api.EndpointApi
import aksamedia.com.tugasaksa4_saiful.contract.MainView
import aksamedia.com.tugasaksa4_saiful.model.LeagueResponse
import aksamedia.com.tugasaksa4_saiful.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {
    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data1 = gson.fromJson(apiRepository
                    .lakukanRequest1(EndpointApi.tampilkanTim(league)),
                    TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                data1.teams?.let{
                    view.showTeamList(data1.teams)
                }
            }
        }
    }

    fun getListLiga(){
        view.showLoading()
        doAsync {
            val data2 = gson.fromJson(apiRepository.lakukanRequest2
                (EndpointApi.tampilkanListLiga()),
                LeagueResponse::class.java
            )


            uiThread {
                view.hideLoading()
                data2.league?.let{
                    view.showListLiga(data2.league)
                }
            }
        }
    }
}