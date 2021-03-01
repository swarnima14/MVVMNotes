package com.app.appnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NotesAdapter.Iadapter {

    lateinit var notesViewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesAdapter(this, this)
        recyclerView.adapter = adapter

        notesViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
                .get(NotesViewModel::class.java)
        notesViewModel.notesData.observe(this, Observer {
            if(it != null){
                adapter.updateList(it)
            }

        })

        btnAdd.setOnClickListener {
            val text = etText.text.toString()
            if(text.isNotEmpty())
            {
                notesViewModel.insertData(Notes(text))
                Toast.makeText(this, "$text inserted", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onClick(notes: Notes) {
        notesViewModel.delData(notes)
        Toast.makeText(this, "${notes.text} deleted.", Toast.LENGTH_SHORT).show()
    }
}