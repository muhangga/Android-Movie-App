package com.example.movieapp.OnBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.R
import com.example.movieapp.sign.signin.SignInActivity
import com.example.movieapp.utils.Preferences
import kotlinx.android.synthetic.main.activity_onboarding_one.*

class OnboardingOneActivity : AppCompatActivity() {

    lateinit var preference : Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)

        preference = Preferences(this)

        if (preference.getValues("onboarding").equals("1")) {
            finishAffinity()
            startActivity(Intent(this, SignInActivity::class.java))
        }

        btn_lanjut.setOnClickListener {
            val lanjut = Intent(this, OnboardingTwoActivity::class.java)
            startActivity(lanjut)
        }

        btn_lewati.setOnClickListener {
            preference.setValues("onboarding", "1")
            finishAffinity()
            val lewati = Intent(this, SignInActivity::class.java)
            startActivity(lewati)
        }
    }
}
