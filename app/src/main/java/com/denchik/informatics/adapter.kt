package com.denchik.informatics

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.net.Uri
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.animation.Animation
import android.view.animation.AnimationUtils


data class web(val klass : Int, val name : String, val webAddress : String)
class adapter(private val webs: List<web>) : RecyclerView.Adapter<adapter.viewHolder>(){

    private var lastPosition = -1
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.webName)
        val klass: TextView = itemView.findViewById(R.id.klassItem)
        val view : ConstraintLayout = itemView.findViewById(R.id.layoutItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.name.text = webs[position].name
        holder.klass.text = webs[position].klass.toString()
        holder.view.setOnClickListener {
            val url = webs[position].webAddress
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            holder.view.context.startActivity(i)
        }
        setAnimation(holder.itemView, position);
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            val animation: Animation =
                AnimationUtils.loadAnimation(viewToAnimate.context, android.R.anim.slide_in_left)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }


    override fun getItemCount() = webs.size
}