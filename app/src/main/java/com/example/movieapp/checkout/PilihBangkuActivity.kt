/*
 *
 * Written by Muhamad Angga
 *
 */

package com.example.movieapp.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.movieapp.R
import com.example.movieapp.models.CheckoutModel
import com.example.movieapp.models.FilmModel
import kotlinx.android.synthetic.main.activity_pilih_bangku.*

class PilihBangkuActivity : AppCompatActivity() {

    var statusA1: Boolean = false
    var statusA2: Boolean = false
    var statusA3: Boolean = false
    var statusA4 : Boolean = false
    var statusB1: Boolean = false
    var statusB2: Boolean = false
    var statusB3: Boolean = false
    var statusB4 : Boolean = false
    var total : Int = 0

    private var dataList = ArrayList<CheckoutModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_bangku)

        val data = intent.getParcelableExtra<FilmModel>("data")

        tv_kursi.text = data?.judul

        cekKursi()

        btn_beli_tiket.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun beliTiket(total: Int) {
        if (total == 0) {
            btn_beli_tiket.setText("Beli Tiket")
            btn_beli_tiket.visibility = View.INVISIBLE
        }
        else {
            btn_beli_tiket.setText("Beli Tiket (" + total +")")
            btn_beli_tiket.visibility = View.VISIBLE
        }
    }

    fun cekKursi() {

        a1.setOnClickListener {
            if (statusA1) {
                a1.setImageResource(R.drawable.ic_rectangle_empty)
                statusA1 = false
                total -= 1
                beliTiket(total)
            } else {
                a1.setImageResource(R.drawable.ic_rectangle_selected)
                statusA1 = true
                total += 1
                beliTiket(total)

                val data = CheckoutModel("A1", "70000")
                dataList.add(data)
            }
        }

        a2.setOnClickListener {
            if (statusA2) {
                a2.setImageResource(R.drawable.ic_rectangle_empty)
                statusA2 = false
                total -= 1
                beliTiket(total)
            } else {
                a2.setImageResource(R.drawable.ic_rectangle_selected)
                statusA2 = true
                total += 1
                beliTiket(total)

                val data = CheckoutModel("A2", "70000")
                dataList.add(data)
            }
        }

        a3.setOnClickListener {
            if (statusA3) {
                a3.setImageResource(R.drawable.ic_rectangle_empty)
                statusA3 = false
                total -= 1
                beliTiket(total)
            } else {
                a3.setImageResource(R.drawable.ic_rectangle_selected)
                statusA3 = true
                total += 1
                beliTiket(total)

                val data = CheckoutModel("A3", "70000")
                dataList.add(data)
            }
        }
        a4.setOnClickListener {
            if (statusA4) {
                a4.setImageResource(R.drawable.ic_rectangle_empty)
                statusA4 = false
                total -= 1
                beliTiket(total)
            } else {
                a4.setImageResource(R.drawable.ic_rectangle_selected)
                statusA4 = true
                total += 1
                beliTiket(total)

                val data = CheckoutModel("A4", "70000")
                dataList.add(data)
            }
        }

        b1.setOnClickListener {
            if (statusB1) {
                b1.setImageResource(R.drawable.ic_rectangle_empty)
                statusB1 = false
                total -= 1
                beliTiket(total)
            } else {
                b1.setImageResource(R.drawable.ic_rectangle_selected)
                statusB1 = true
                total += 1
                beliTiket(total)

                val data = CheckoutModel("B1", "70000")
                dataList.add(data)
            }
        }

        b2.setOnClickListener {
            if (statusB2) {
                b2.setImageResource(R.drawable.ic_rectangle_empty)
                statusB2 = false
                total -= 1
                beliTiket(total)
            } else {
                b2.setImageResource(R.drawable.ic_rectangle_selected)
                statusB2 = true
                total += 1
                beliTiket(total)

                val data = CheckoutModel("B2", "70000")
                dataList.add(data)
            }
        }

        b3.setOnClickListener {
            if (statusB3) {
                b3.setImageResource(R.drawable.ic_rectangle_empty)
                statusB3 = false
                total -= 1
                beliTiket(total)
            } else {
                b3.setImageResource(R.drawable.ic_rectangle_selected)
                statusB3 = true
                total += 1
                beliTiket(total)

                val data = CheckoutModel("B3", "70000")
                dataList.add(data)
            }
        }
        b4.setOnClickListener {
            if (statusB4) {
                b4.setImageResource(R.drawable.ic_rectangle_empty)
                statusB4 = false
                total -= 1
                beliTiket(total)
            } else {
                b4.setImageResource(R.drawable.ic_rectangle_selected)
                statusB4 = true
                total += 1
                beliTiket(total)

                val data = CheckoutModel("B4", "70000")
                dataList.add(data)
            }
        }

    }
}
