package com.example.notepad

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "note_table")
data class Note (
    @ColumnInfo(name = "note_title")
    var title: String,

    @ColumnInfo(name = "note_date")
    var lastUpdated: Date,

    @ColumnInfo(name = "note_text")
    var text: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
) : Parcelable