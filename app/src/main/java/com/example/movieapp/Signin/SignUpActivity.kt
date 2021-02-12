package com.example.movieapp.Signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.R
import com.example.movieapp.SignUpPhotoScreenActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btn_sign_up.setOnClickListener {
            val intent = Intent(this, SignUpPhotoScreenActivity::class.java)
            startActivity(intent)
        }
    }
}
