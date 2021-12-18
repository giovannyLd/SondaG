package com.example.sondag

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class start_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    fun salir(view: android.view.View) {

        val getOut = Intent(this,MainActivity::class.java)
        startActivity(getOut)
    }
}