/*
 *
 * Written by Muhamad Angga
 *
 */

package com.example.movieapp.home.tiket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.models.CheckoutModel
import com.example.movieapp.models.FilmModel
import kotlinx.android.synthetic.main.activity_tiket.*

class TiketActivity : AppCompatActivity() {

    private var dataList = ArrayList<CheckoutModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiket)

        var data = intent.getParcelableExtra<FilmModel>("data")

        tv_title.text = data?.judul
        tv_genre.text = data?.genre
        tv_rate.text = data?.rating

        Glide.with(this)
            .load(data?.poster)
            .into(iv_poster_image)

        rv_checkout.layoutManager = LinearLayoutManager(this)
        dataList.add(CheckoutModel("C1", ""))
        dataList.add(CheckoutModel("C2", ""))

        rv_checkout.adapter = TiketAdapter(dataList) {

        }
    }
}
