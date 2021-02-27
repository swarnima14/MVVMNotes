package com.app.appnotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Notes(@ColumnInfo(name ="notes")val text: String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}