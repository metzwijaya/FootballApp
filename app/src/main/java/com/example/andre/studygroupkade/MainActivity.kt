package com.example.andre.studygroupkade

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.andre.studygroupkade.R.array.*
import com.example.andre.studygroupkade.model.ClubModel
import com.example.andre.studygroupkade.model.TeamModel
import com.example.andre.studygroupkade.network.ApiRepository
import com.example.andre.studygroupkade.view.MainView
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), MainView {
    val data = ArrayList<ClubModel>()

    var response : MutableList<TeamModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateData()

        val gson = Gson()
        val request = ApiRepository()
        val presenter = MainPresenter(this, request, gson)
        presenter.getTeamList("German%20Bundesliga")

        linearLayout {
            padding = dip(8)
            lparams(width = matchParent, height = matchParent)

            recyclerView {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = MainAdapter(data) { data ->
                    toast(data.teamName)
                }
            }
        }
    }

    private fun generateData() {
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        val desc = resources.getStringArray(club_desc)

        data.clear()
        for (i in name.indices) {
            data.add(ClubModel(name[i], image.getResourceId(i, 0), desc[i]))
        }

        image.recycle()

    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showTeamList(data: List<TeamModel>) {
        response.clear()
        response.addAll(data)
    }
}



