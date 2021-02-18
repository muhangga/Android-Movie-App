/*
 *
 * Written by Muhamad Angga
 *
 */

package com.example.movieapp.checkout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.models.CheckoutModel
import java.text.NumberFormat
import java.util.*

class CheckoutAdapter(private var data: List<CheckoutModel>,
                      private val listener : (CheckoutModel) -> Unit)
    : RecyclerView.Adapter<CheckoutAdapter.NewPlayingViewHolder>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): NewPlayingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context

        val inflatedView = layoutInflater.inflate(R.layout.row_item_checkout, parent, false)
        return NewPlayingViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NewPlayingViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    class NewPlayingViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val tvTitle = view.findViewById<TextView>(R.id.tv_kursi)
        private val tvHarga = view.findViewById<TextView>(R.id.tv_harga)

        fun bindItem(data: CheckoutModel, listener: (CheckoutModel) -> Unit, context: Context) {

            val localID = Locale("id", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(localID)
            tvHarga.setText(formatRupiah.format(data.harga!!.toDouble()))

            if (data.kursi!!.startsWith("Total")) {
                tvTitle.setText(data.kursi)
                tvTitle.setCompoundDrawables(null, null, null, null)
            }
            else {
                tvTitle.setText("Seat No " + data.kursi)
            }

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}
