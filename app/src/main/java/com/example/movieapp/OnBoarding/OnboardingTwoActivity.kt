package com.example.movieapp.OnBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.R
import kotlinx.android.synthetic.main.activity_onboarding_two.btn_lanjut

class OnboardingTwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_two)

        btn_lanjut.setOnClickListener {
            val lanjut = Intent(this, OnboardingThreeActivity::class.java)
            startActivity(lanjut)
        }
    }
}
