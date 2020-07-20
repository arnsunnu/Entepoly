package com.exflater.entepoly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        // Initialize Firebase Auth
        auth = Firebase.auth
       /* var db= FirebaseDatabase.getInstance().reference
        db.setValue("Testing...")*/
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            Toast.makeText(this, "Hai..", Toast.LENGTH_LONG).show()
           var status= if (uname.text.toString().equals("abc") && pwd.text.toString().equals("123")) "login successfull" else "Login Failed"
            Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            val intent =Intent(this,Reg::class.java)
            startActivity(intent)
        }
    }
}