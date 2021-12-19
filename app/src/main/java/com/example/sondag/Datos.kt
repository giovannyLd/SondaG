package com.example.sondag

import com.google.firebase.firestore.FirebaseFirestore

class Datos(value: ArrayList<String>){

    var db = FirebaseFirestore.getInstance()
    var valor: ArrayList<String> = value


    fun toBringDB() {

        var returnValue:ArrayList<Double>
        returnValue=dataNumber(valor)
       println("hola como van jajjaj si funciona "+ returnValue)


    }

    private fun dataNumber(lista:ArrayList<String>):ArrayList<Double> {

        var number:ArrayList<Double> = ArrayList()

        for(x in lista) {
             number.add((x.substringAfter("fecha=")).substringBefore("}").toDouble())
        }
            return number
    }
}