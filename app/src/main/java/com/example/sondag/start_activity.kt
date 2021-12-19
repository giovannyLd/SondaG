package com.example.sondag

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore

class start_activity : AppCompatActivity() {

    var db= FirebaseFirestore.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    fun salir(view: android.view.View) {

        val getOut = Intent(this,MainActivity::class.java)
        startActivity(getOut)
    }

    fun toBringBD(view: android.view.View) {
        var lista: ArrayList<String> = ArrayList()


        db.collection("lista").whereGreaterThan("fecha", 2).get()
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