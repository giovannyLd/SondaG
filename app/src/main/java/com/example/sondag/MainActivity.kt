package com.example.sondag

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class MainActivity : AppCompatActivity() {

    var db = FirebaseFirestore.getInstance()
    var listaPrueba = mutableListOf<Double>(100.32,200.00,333.98,400.23,300.00,298.93)
    var x:Double=0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goMainActivity(view: android.view.View) {

/*        db.collection("Formulario").document("giovanny").set(
            hashMapOf("nombre" to "giovanny fandiño motnes "))*/
        var y=0

        for(x in listaPrueba ){

            if(x != 0.0) {

                val listaProductos = hashMapOf(

                    "fecha" to x

                )

                var coleccion = db.collection("lista").document()
                    .set(listaProductos)
                    .addOnSuccessListener { println("DocumentSnapshot successfully written!") }
                    .addOnFailureListener { e -> println("Error writing document" + e) }
            }

            y++
        }

        val start = Intent(this,start_activity::class.java)
        startActivity(start)
        Toast.makeText(this,"si funciona bootn",Toast.LENGTH_LONG).show()
    }
}