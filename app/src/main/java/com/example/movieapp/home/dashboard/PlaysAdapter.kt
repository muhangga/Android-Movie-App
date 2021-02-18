/*
 *
 * Written by Muhamad Angga
 *
 */

package com.example.movieapp.home.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.R
import com.example.movieapp.models.PlaysModel

class PlaysAdapter(private var data: List<PlaysModel>,
                   private val listener : (PlaysModel) -> Unit)
    : RecyclerView.Adapter<PlaysAdapter.NewPlayingViewHolder>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): PlaysAdapter.NewPlayingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context

        val inflatedView = layoutInflater.inflate(R.layout.row_item_plays, parent, false)
        return NewPlayingViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PlaysAdapter.NewPlayingViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    class NewPlayingViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val tvTitle = view.findViewById<TextView>(R.id.tv_kursi)
        private val tvImage = view.findViewById<ImageView>(R.id.iv_poster_image)

        fun bindItem(data: PlaysModel, listener: (PlaysModel) -> Unit, context: Context) {
            tvTitle.setText(data.nama)

            Glide.with(context)
                .load(data.url)
                .apply(RequestOptions.circleCropTransform())
                .into(tvImage)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}
