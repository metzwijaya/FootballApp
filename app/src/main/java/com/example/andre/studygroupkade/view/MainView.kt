package com.example.andre.studygroupkade.view

import com.example.andre.studygroupkade.model.TeamModel

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data : List<TeamModel>)
}

