package com.example.reminder_3

import androidx.lifecycle.LiveData
import androidx.room.*

// data access objects
// Data Access Objects are the main classes where you define your database interactions.
@Dao
interface ReminderDao {

    @Query("SELECT * FROM reminderTable")
    fun getAllReminders(): LiveData<List<Reminder>>

    @Insert
    suspend fun insertReminder(reminder: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)

    @Update
    suspend fun updateReminder(reminder: Reminder)

}
