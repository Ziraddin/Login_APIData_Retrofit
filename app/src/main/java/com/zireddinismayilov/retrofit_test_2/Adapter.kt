package com.zireddinismayilov.retrofit_test_2

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(list: List<StudentDTO>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var list: List<StudentDTO>

    init {
        this.list = list
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name)
        var surname = itemView.findViewById<TextView>(R.id.surname)
        var age = itemView.findViewById<TextView>(R.id.age)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_element, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(list.get(position).name)
        holder.surname.setText(list.get(position).surname)
        holder.age.setText(list.get(position).age)
    }

}