package com.example.andre.studygroupkade

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.andre.studygroupkade.model.ClubModel
import com.example.andre.studygroupkade.model.TeamModel
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainAdapter(val list: MutableList<TeamModel>, val listener:(TeamModel) -> (Unit)) : RecyclerView.Adapter<MainAdapter.MainViewHolder>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainViewHolder = MainViewHolder(AdapterUI().createView(
        AnkoContext.Companion.create(p0.context)))


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(view: MainViewHolder, position: Int) {
        view.bind(list[position], listener)
    }


    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageClub = itemView.find<ImageView>(R.id.imageClub)
        val nameClub = itemView.find<TextView>(R.id.nameClub)

        fun bind(teamModel: TeamModel, listener: (TeamModel) -> Unit) {
            nameClub.text = teamModel.teamName
            Glide.with(itemView.context).load(teamModel.teamBadge).into(imageClub)
            itemView.onClick{
                listener(teamModel)
            }
        }

    }
}

class AdapterUI : AnkoComponent<Context> {
    override fun createView(ui: AnkoContext<Context>): View = with(ui) {

                linearLayout {
                    padding = dip(8)
                    imageView {
                        id = R.id.imageClub
                    }.lparams(width = dip(48), height = dip(48)) {
                        rightMargin = dip(8)
                    }

                    textView{
                        textSize = sp(12).toFloat()
                        id = R.id.nameClub
                    }.lparams(width = wrapContent)
                }
            }

}