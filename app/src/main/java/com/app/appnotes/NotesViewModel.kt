package com.app.appnotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NotesViewModel(application: Application): AndroidViewModel(application) {

    val notesData: LiveData<List<Notes>>
    val repo: NotesRepository
    init {
        val dao = NotesDatabase.getDatabase(application).getNotesDao()
        repo = NotesRepository(dao)
        notesData = repo.allNotes
    }
    fun insertData(notes: Notes) = viewModelScope.launch(Dispatchers.IO){
        repo.insert(notes)
    }
    fun delData(notes: Notes) = viewModelScope.launch(Dispatchers.IO){
        repo.delete(notes)
    }
}