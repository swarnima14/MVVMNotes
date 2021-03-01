package com.app.appnotes

import androidx.lifecycle.LiveData

class NotesRepository(private val notesDao: NotesDao) {

    val allNotes: LiveData<List<Notes>> = notesDao.getAll()
    suspend fun insert(note: Notes){
        notesDao.insert(note)
    }
    suspend fun delete(note: Notes){
        notesDao.delete(note)
    }
}