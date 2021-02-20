/*
 *
 * Written by Muhamad Angga
 *
 */

package com.example.movieapp.home.tiket


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.movieapp.R
import com.example.movieapp.home.dashboard.ComingSoonAdapter
import com.example.movieapp.models.FilmModel
import com.example.movieapp.utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_tiket.*

/**
 * A simple [Fragment] subclass.
 */
class TiketFragment : Fragment() {

    private lateinit var preferences: Preferences
    private lateinit var mDatabase : DatabaseReference
    private var dataList = ArrayList<FilmModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tiket, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preferences = Preferences(context!!)
        mDatabase   = FirebaseDatabase.getInstance().getReference("Film")

        rv_tiket.layoutManager = LinearLayoutManager(context)
        getData()
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(context, databaseError.message, Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
               dataList.clear()

                for (getDataSnapshot in dataSnapshot.children) {
                    val film = getDataSnapshot.getValue(FilmModel::class.java)
                    dataList.add(film!!)
                }

                rv_tiket.adapter = ComingSoonAdapter(dataList) {
                    val intent = Intent(context, TiketActivity::class.java)
                        .putExtra("data", it)
                    startActivity(intent)
                }

                tv_total.setText("${dataList.size} Movies")
            }

        })
    }

}
