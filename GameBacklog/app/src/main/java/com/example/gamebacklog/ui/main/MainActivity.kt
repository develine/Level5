package com.example.gamebacklog.ui.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklog.R
import com.example.gamebacklog.model.Game
import com.example.gamebacklog.ui.AddActivityViewModel
import com.example.gamebacklog.ui.GameAdapter
import com.example.gamebacklog.ui.MainActivityViewModel
import com.example.gamebacklog.ui.add.AddActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val games = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(games)
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        init()
        fab.setOnClickListener { redirect() }
    }

    private fun init(){
        rvGames.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        rvGames.adapter = gameAdapter

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        // Observe reminders from the view model, update the list when the data is changed.
       viewModel.games.observe(this, Observer { reminders ->
           if (reminders != null) {
               this@MainActivity.games.clear()
               this@MainActivity.games.addAll(reminders)
               gameAdapter.notifyDataSetChanged()
           }
        })
    }

    private fun redirect(){
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }







    // Icons
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
