package com.example.sondag

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goMainActivity(view: android.view.View) {

        val start = Intent(this,start_activity::class.java)
        startActivity(start)
        Toast.makeText(this,"si funciona bootn",Toast.LENGTH_LONG).show()
    }
}