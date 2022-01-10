package com.example.myuas2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myuas2.Model.Model
import com.example.myuas2.R

class Adapter (
    val hp: ArrayList<Model.Data>
): RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter, parent, false)
    )

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val data = hp[position]
        holder.textNama.text = data.nama
        holder.textHarga.text = data.harga
    }

    override fun getItemCount() = hp.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textNama = view.findViewById<TextView>(R.id.textnama)
        val textHarga = view.findViewById<TextView>(R.id.textharga)
    }

    public fun setData(data: List<Model.Data>){
        hp.clear()
        hp.addAll(data)
        notifyDataSetChanged()
    }

}