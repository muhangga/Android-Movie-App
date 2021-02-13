package com.example.movieapp.OnBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.R
import com.example.movieapp.sign.SignInActivity
import kotlinx.android.synthetic.main.activity_onboarding_one.*

class OnboardingOneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)

        btn_lanjut.setOnClickListener {
            val lanjut = Intent(this, OnboardingTwoActivity::class.java)
            startActivity(lanjut)
        }

        btn_lewati.setOnClickListener {
            val lewati = Intent(this, SignInActivity::class.java)
            startActivity(lewati)
        }
    }
}
