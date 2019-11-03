package com.example.reminder_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*

const val EXTRA_REMINDER = "EXTRA_REMINDER"

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { onSaveClick() }
    }

    private fun onSaveClick(){

        if(etAddReminder.text.toString().isEmpty()){
            Toast.makeText(applicationContext, "Please enter a reminder! ", Toast.LENGTH_SHORT).show()
        }else{
            // Create a reminder object
            val reminder = Reminder(etAddReminder.text.toString())
            // Intent -> envelope/package: Create an Intent
            val resultIntent = Intent()
            // Add the reminder to the Intent, as an extra object. So code 100 and EXTRA REMINDER will be sent back
            // Inside package 100->EXTRA REMINDER
            resultIntent.putExtra(EXTRA_REMINDER, reminder)
            // The result of the activity is set to RESULT_OK indicating that everything went well
            // In other words, we can let the other page know we're done sending the reminder
            setResult(Activity.RESULT_OK, resultIntent)
            // Remove activity (from pile of activities)
            finish()
        }

    }

}
