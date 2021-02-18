/*
 *
 * Written by Muhamad Angga
 *
 */

package com.example.movieapp.sign.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movieapp.R
import com.example.movieapp.sign.signin.User
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    
    lateinit var iUsername : String
    lateinit var iPassword : String
    lateinit var iNama : String
    lateinit var iEmail : String
    lateinit var mDatabaseReference: DatabaseReference
    lateinit var mFirebaseInstance : FirebaseDatabase
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReference()
        mDatabaseReference = mFirebaseInstance.getReference("User")

        btn_sign_up.setOnClickListener {

            iUsername = et_username.text.toString()
            iPassword = et_password.text.toString()
            iNama = et_nama.text.toString()
            iEmail = et_email.text.toString()
            
            if (iUsername.equals("")) {
                et_username.error = "Silakan isi Username Anda"
                et_username.requestFocus()
            }
            else if (iPassword.equals("")) {
                et_password.error = "Silakan isi Password Anda"
                et_password.requestFocus()
            }
            else if (iNama.equals("")) {
                et_nama.error = "Silakan isi Nama Anda"
                et_nama.requestFocus()
            }
            else if (iEmail.equals("")) {
                et_email.error = "Silakan isi Email Anda"
                et_email.requestFocus()
            }
            else {
                saveData(iUsername, iPassword, iNama, iEmail)
            }
        }
    }

    private fun saveData(iUsername: String, iPassword: String, iNama: String, iEmail: String) {

        var user = User()
        user.email = iEmail
        user.username = iUsername
        user.nama = iNama
        user.password = iPassword

        if (iUsername != null) {
            cekUsername(iUsername, user)
        }
    }

    private fun cekUsername(iUsername: String, data: User) {
        mDatabaseReference.child(iUsername).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var user = dataSnapshot.getValue(User::class.java)

                if (user == null) {
                    mDatabaseReference.child(iUsername).setValue(data)
                    startActivity(Intent(this@SignUpActivity, SignUpPhotoScreenActivity::class.java)
                        .putExtra("nama", data?.nama))
                }
                else {
                    Toast.makeText(this@SignUpActivity, "User sudah digunakan", Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@SignUpActivity, " " + databaseError.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
