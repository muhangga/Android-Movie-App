/*
 *
 * Written by Muhamad Angga
 *
 */

package com.example.movieapp.sign.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movieapp.HomeActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import com.example.movieapp.R
import com.example.movieapp.sign.SignUpActivity
import com.example.movieapp.utils.Preferences
import com.google.firebase.database.*


class SignInActivity : AppCompatActivity() {

    lateinit var iUsername : String
    lateinit var iPassword : String
    lateinit var mDatabase : DatabaseReference
    lateinit var preference : Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preference = Preferences(this)

        preference.setValues("onboarding", "1")
        if (preference.getValues("status").equals("1")) {
            finishAffinity()
            startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
        }

       btn_login.setOnClickListener {
           iUsername = et_username.text.toString()
           iPassword = et_password.text.toString()

           if (iUsername.equals("")) {
               et_username.error = "Silahkan isi username anda"
               et_username.requestFocus()
           }
           else if (iPassword.equals("")) {
               et_password.error = "Silahkan isi Password anda"
               et_password.requestFocus()
           }
           else {
               pushLogin(iUsername, iPassword)
           }
       }

        btn_daftar.setOnClickListener {
            val toSignUp = Intent(this, SignUpActivity::class.java)
            startActivity(toSignUp)
        }
    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var user = dataSnapshot.getValue(User::class.java)

                if (user == null) {
                    Toast.makeText(this@SignInActivity, "User Anda tidak ditemukan",
                        Toast.LENGTH_LONG).show()
                } else {

                    if (user.password.equals(iPassword)) {
                        preference.setValues("nama", user.nama.toString())
                        preference.setValues("user", user.username.toString())
                        preference.setValues("url", user.url.toString())
                        preference.setValues("email", user.email.toString())
                        preference.setValues("saldo", user.saldo.toString())
                        preference.setValues("status", "1")

                        var intent = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@SignInActivity, "Password Anda Salah, Silakan coba lagi",
                            Toast.LENGTH_LONG).show()
                    }

                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@SignInActivity, databaseError.message,
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}
