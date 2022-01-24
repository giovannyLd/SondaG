package com.example.sondag

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var db = FirebaseFirestore.getInstance()

    private lateinit var imagenView: ImageView
    private lateinit var tv: TextView
    var listaPrueba = mutableListOf<Double>(100.32, 200.00, 333.98, 400.23, 300.00, 298.93)
    var x: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagenView = findViewById(R.id.imagenMain)
        tv= findViewById(R.id.idView)

        db.collection("recursos").get()
            .addOnSuccessListener { result ->
                for (document in result) {

                    var imagenPrincipal= document.data.toString().substringAfter("{imagen=").substringBefore("}")
                    Picasso.get().load("http://www.speedtest.net/result/12631686908.png").into(imagenView);
                tv.setText(imagenPrincipal)
                }

            }

    }

/*    fun goMainActivity(view: android.view.View) {
        println("hola mundooooo")
        var y = 0
        for (x in listaPrueba) {
            if (x != 0.0) {
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

        val start = Intent(this, menu_activity::class.java)
        startActivity(start)
        Toast.makeText(this, "si funciona bootn", Toast.LENGTH_LONG).show()
    }*/


    fun goMainActivity(view: android.view.View) {

        val start = Intent(this, ConexionFireBase::class.java)
        startActivity(start)
        Toast.makeText(this,"si funciona",Toast.LENGTH_LONG).show()

    }
}
