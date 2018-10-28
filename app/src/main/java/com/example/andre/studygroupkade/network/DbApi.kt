package com.example.andre.studygroupkade.network

import com.example.andre.studygroupkade.BuildConfig

object DbApi{

    fun getTeams(league: String?) : String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "search_all_teams.php?l=" + league
    }

}