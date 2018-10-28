package com.example.andre.studygroupkade

import com.example.andre.studygroupkade.model.TeamModel
import com.example.andre.studygroupkade.model.TeamResponse
import com.example.andre.studygroupkade.network.ApiRepository
import com.example.andre.studygroupkade.network.DbApi
import com.example.andre.studygroupkade.view.MainView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view : MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson)
{
    fun getTeamList(league : String) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(DbApi.getTeams(league)),
                TeamResponse::class.java)

            uiThread {
                view.showLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}
