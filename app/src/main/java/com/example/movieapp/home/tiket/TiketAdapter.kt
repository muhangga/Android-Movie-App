/*
 *
 * Written by Muhamad Angga
 *
 */


package com.example.movieapp.home.tiket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.models.CheckoutModel
import java.text.NumberFormat
import java.util.*

class TiketAdapter(private var data: List<CheckoutModel>,
                   private val listener : (CheckoutModel) -> Unit)
    : RecyclerView.Adapter<TiketAdapter.NewPlayingViewHolder>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): NewPlayingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context

        val inflatedView = layoutInflater.inflate(R.layout.row_item_checkout_white, parent, false)
        return NewPlayingViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NewPlayingViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    class NewPlayingViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val tvTitle = view.findViewById<TextView>(R.id.tv_kursi)

        fun bindItem(data: CheckoutModel, listener: (CheckoutModel) -> Unit, context: Context) {
            tvTitle.setText("Seat No "+data.kursi)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}
