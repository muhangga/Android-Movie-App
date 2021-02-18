package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.checkout.PilihBangkuActivity
import com.example.movieapp.home.dashboard.PlaysAdapter
import com.example.movieapp.models.FilmModel
import com.example.movieapp.models.PlaysModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var mDatabase : DatabaseReference
    private var dataList = ArrayList<PlaysModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<FilmModel>("data")

        mDatabase = FirebaseDatabase.getInstance().getReference("Film")
            .child(data?.judul.toString())
            .child("play")

        tv_kursi.text = data?.judul
        tv_genre.text = data?.genre
        tv_desc.text = data?.desc
        tv_rate.text = data?.rating

        Glide.with(this)
            .load(data?.poster)
            .into(iv_poster)

        rv_who_play.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        getData()

        btn_pilih_bangku.setOnClickListener {
            startActivity(Intent(this, PilihBangkuActivity::class.java)
                .putExtra("data", data))
        }
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataList.clear()

                for (getdataSnapshot in dataSnapshot.children) {
                    var Film = getdataSnapshot.getValue(PlaysModel::class.java)
                    dataList.add(Film!!)
                }

                rv_who_play.adapter = PlaysAdapter(dataList) {

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@DetailActivity, "" + databaseError.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
