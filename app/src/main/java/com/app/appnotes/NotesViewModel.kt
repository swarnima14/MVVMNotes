package com.app.appnotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NotesViewModel(application: Application): AndroidViewModel(application) {

    val notesData: LiveData<List<Notes>>
    init {
        val dao = NotesDatabase.getDatabase(application).getNotesDao()
        val repo = NotesRepository(dao)
        notesData = repo.allNotes
    }
}