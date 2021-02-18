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
import com.example.movieapp.R
import com.example.movieapp.models.FilmModel
import kotlinx.android.synthetic.main.row_item_now_playing.view.*

class ComingSoonAdapter(private var data: List<FilmModel>,
                        private val listener : (FilmModel) -> Unit)
    : RecyclerView.Adapter<ComingSoonAdapter.NewPlayingViewHolder>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ComingSoonAdapter.NewPlayingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context

        val inflatedView = layoutInflater.inflate(R.layout.row_item_coming_soon, parent, false)
        return NewPlayingViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ComingSoonAdapter.NewPlayingViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    class NewPlayingViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val tvTitle = view.findViewById<TextView>(R.id.tv_kursi)
        private val tvGenre = view.findViewById<TextView>(R.id.tv_genre)
        private val tvRate = view.findViewById<TextView>(R.id.tv_rate)
        private val tvImage = view.findViewById<ImageView>(R.id.iv_poster_image)

        fun bindItem(data: FilmModel, listener: (FilmModel) -> Unit, context: Context) {
            tvTitle.setText(data.judul)
            tvGenre.setText(data.genre)
            tvRate.setText(data.rating)

            Glide.with(context)
                .load(data.poster)
                .into(tvImage)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}
