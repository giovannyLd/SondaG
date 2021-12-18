package com.example.sondag

import com.google.firebase.firestore.FirebaseFirestore

class Datos(value: ArrayList<String>){

    var db = FirebaseFirestore.getInstance()
    var valor: ArrayList<String> = value


    fun toBringDB() {

        println("desde toBringDB ${valor}")


    }
}