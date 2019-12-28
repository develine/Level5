package com.example.gamebacklog.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Game (
    var title: String,
    var date: Date,
    var platform: String,
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
)