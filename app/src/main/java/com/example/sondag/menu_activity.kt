package com.example.sondag

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

class menu_activity : AppCompatActivity() {

    var db= FirebaseFirestore.getInstance()

    private lateinit var imagenView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)




        println("hola si ingres a start activity")
    }

    fun salir(view: android.view.View) {

        val getOut = Intent(this,MainActivity::class.java)
        startActivity(getOut)
    }

    fun toBringBD(view: android.view.View) {
        var lista: ArrayList<String> = ArrayList()


        db.collection("giovanny").whereGreaterThan("fecha", 2).get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    println("en la clase Datos: ${document.id} => ${document.data}")
//                    lista1.add("${document.data}".toString())
                    lista.add("${document.data}")

                }
                var datos:Datos=Datos(lista)
                println(datos.toBringDB())

            }







}
}