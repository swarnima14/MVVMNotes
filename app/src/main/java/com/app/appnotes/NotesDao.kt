package com.app.appnotes

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface NotesDao {

    @Insert
    suspend fun insert(note: Notes)

    @Delete
    suspend fun delete(note: Notes)

    @Query("SELECT * FROM notes_table")
    fun getAll(): LiveData<List<Notes>>
}