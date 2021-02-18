/*
 *
 * Written by Muhamad Angga
 *
 */

package com.example.movieapp.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.EditProfileActivity
import com.example.movieapp.R
import com.example.movieapp.models.CheckoutModel
import com.example.movieapp.utils.Preferences
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : AppCompatActivity() {

    private var dataList = ArrayList<CheckoutModel>()
    private var total : Int = 0
    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        preferences = Preferences(this)
        dataList = intent.getSerializableExtra("data") as ArrayList<CheckoutModel>

        for (a in dataList.indices) {
            total += dataList[a].harga!!.toInt()
        }

        dataList.add(CheckoutModel("Total harus dibayar", total.toString()))

        rv_checkout.layoutManager = LinearLayoutManager(this)
        rv_checkout.adapter = CheckoutAdapter(dataList) {

        }

        btn_bayar_sekarang.setOnClickListener {
            val intent = Intent(this, CheckoutSuccessActivity::class.java)
            startActivity(intent)
        }
    }
}
