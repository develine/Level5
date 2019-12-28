package com.example.gamebacklog.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklog.R
import com.example.gamebacklog.model.Game
import kotlinx.android.synthetic.main.one_item.view.*

class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        // one_item -> one_item.xml
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.one_item, parent, false)
        )
    }

    // One viewholder's properties
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(game: Game) {
            itemView.item_tvTitle.text = game.title
            itemView.item_tvPlatform.text = game.platform
            itemView.item_tvDate.text = "Release: " + game.date.toString()
        }
    }

    // Array size
    override fun getItemCount(): Int {
        return games.size
    }

    // Bind viewholder to position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(games[position])
    }
}