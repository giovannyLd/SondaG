package com.example.sondag

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.sondag.databinding.ActivityMainBinding
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase



class ConexionFireBase : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    private lateinit var database: DatabaseReference
    protected var tvDatos: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_conexion_fire_base)

        tvDatos = findViewById(R.id.vista)

    }

    fun registro(view: android.view.View) {

        database=FirebaseDatabase.getInstance().getReference()

        getMensajesFromFirebase()


    }
    fun getMensajesFromFirebase() {

        database.child("dc:a6:32:cd:55:ab").get().addOnSuccessListener{

            var amount= ("${it.childrenCount }").toInt()
            var divide = "${it.value }".split('}')


        for(y in divide) {
            var key = y.substringAfter("-").substringBefore("=")

            println("\n" + key)
        }
           }
           // Toast.makeText(this,divide,Toast.LENGTH_LONG).show()
            //tvDatos!!.setText(divide)

        }
    }
///SI FUNCIONA PERO TRAE TODOS LOS DATOS HASTA LOS SECUNDARIO
/*    fun getMensajesFromFirebase(){

        database.child("dc:a6:32:cd:55:ab")
            .get().addOnSuccessListener {
            println("${it.value}\"")
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
            println("Error getting data"+ it)
        }
    }*/

    //AGREGA DATOS A LA BASE DE DATOS
/*    fun addData() {
        var mensaje: String = "hola mundo "
        database.child("mensaje").push().child("texto").setValue(mensaje)
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()
    }*/



/////codigo para tener en cuenta
/*            @Override
            fun onDataChange(dataSnapshot: DataSnapshot){

            }
            @Override
            fun onCancelled(error: DatabaseError){
            }*/
        //})

        // database.child("mensaje").addChildEventListener(new ValueEventListener(){
        //   database.child("mensaje").setValue()

