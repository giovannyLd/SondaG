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
    var miObjeto:keyFirebase= keyFirebase()


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

        var listaKey = mutableListOf<String>()
        var listaAvg = mutableListOf<String>()

            database.child("dc:a6:32:cd:55:ab").get().addOnSuccessListener{

                var divide = "${it.value }".split('}')

                for(y in divide)
                {
                    var key= "-"+(y.substringAfter("-").substringBefore("="))
                    listaKey.add(key)
                }
                miObjeto.lista=listaKey
                tvDatos!!.setText(miObjeto.lista.toString())

            for(keyAvg in miObjeto.lista){
            database.child("dc:a6:32:cd:55:ab").child(keyAvg).child("avg").get().addOnSuccessListener{

                var avg= "${it.value}"

               listaAvg.add(avg)
                println(listaAvg)
            }}


                }




        }

    class keyFirebase(){

        var documento:String=""
        var lista= mutableListOf<String>()

        fun imprimir(){
            println("esta imprimiendo desde la funcion imprimir de la case keyFirebase")
            println(lista)
        }
        fun imprimirDato(){
             var nombre  = "$documento"


        }
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

