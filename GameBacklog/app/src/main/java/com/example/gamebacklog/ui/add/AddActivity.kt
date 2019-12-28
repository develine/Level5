package com.example.gamebacklog.ui.add

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklog.R
import com.example.gamebacklog.model.Game
import com.example.gamebacklog.ui.AddActivityViewModel
import com.example.gamebacklog.ui.GameAdapter
import com.example.gamebacklog.ui.MainActivityViewModel

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import kotlinx.android.synthetic.main.content_main.*
import java.sql.Date

class AddActivity : AppCompatActivity() {

    //private lateinit var viewModel: AddActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        init()
        fab.setOnClickListener { insert()}
    }

    private fun init(){
        //viewModel = ViewModelProviders.of(this).get(AddActivityViewModel::class.java)
    }

    private fun insert(){


       // viewModel.insertGame(Game("iets", Date(2020,10,2), "PS4"))

       /* viewModel.game.value?.apply {
            title = etTitle.text.toString()
            platform = etPlatform.text.toString()
        }*/
       // viewModel.insertGame()
    }

}
