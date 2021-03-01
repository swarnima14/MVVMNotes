package com.app.appnotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.security.AccessControlContext

class NotesAdapter(private val context: Context, private val listener: Iadapter): RecyclerView.Adapter<NotesAdapter.nViewHolder>() {

    val listNotes = ArrayList<Notes>()

    class nViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val text = itemView.findViewById<TextView>(R.id.tvView)
        val del = itemView.findViewById<ImageView>(R.id.ivDel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): nViewHolder {
        val view = nViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
        view.del.setOnClickListener {
            listener.onClick(listNotes[view.adapterPosition])
        }
        return view
    }

    override fun getItemCount(): Int {
       return listNotes.size
    }

    override fun onBindViewHolder(holder: nViewHolder, position: Int) {

        holder.text.text = listNotes.get(position).text
    }

    fun updateList(newList: List<Notes>){
        listNotes.clear()
        listNotes.addAll(newList)

        notifyDataSetChanged()
    }

    interface Iadapter{
        fun onClick(notes: Notes)
    }

}