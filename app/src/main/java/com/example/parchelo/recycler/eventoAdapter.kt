package com.example.parchelo.recycler

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.parchelo.R



class eventoAdapter(private val eventoList: List<Evento>, private val onClickListener:(Evento) -> Unit): RecyclerView.Adapter<eventoAdapter.eventoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): eventoHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.carta,parent,false)
        return eventoHolder(v)
    }

    override fun getItemCount(): Int {
        return eventoList.size
    }

    override fun onBindViewHolder(holder: eventoHolder, position: Int) {
        val item = eventoList[position]
        holder.render(item, onClickListener)
    }

    inner class eventoHolder(View : View): RecyclerView.ViewHolder(View){
        var titulo = View.findViewById<TextView>(R.id.titulo_evento)
        var fecha = View.findViewById<TextView>(R.id.fecha_evento)
        var lugar = View.findViewById<TextView>(R.id.lugar_evento)
        var foto = View.findViewById<ImageView>(R.id.img_evento)

        fun render(model : Evento, onClickListener:(Evento) -> Unit) {
            titulo.text = model.titulo
            fecha.text = model.fecha
            lugar.text = model.lugar
            foto.setOnClickListener { onClickListener(model)}
        }
    }
}