package com.example.sondag

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidplot.xy.LineAndPointFormatter
import com.androidplot.xy.SimpleXYSeries
import com.androidplot.xy.XYSeries
import com.androidplot.xy.*
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition
import java.util.*
import java.util.Arrays.asList

class prueba3 : AppCompatActivity() {

    private val plot: XYPlot? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba3)

        var plot:XYPlot =findViewById(R.id.plot)

        val domainLabels = arrayOf<Number>(10,20,30,60,70,80,90,10,13,14,15,16,17,18,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,45)
        val serial1Number = arrayOf<Number>(100,120,120,120,160,100,100,120,100,130,130,120,110,100,120,120,120,120,160,100,100,120,100,130,130,120,110,100,120)

        val series1: XYSeries=SimpleXYSeries(Arrays.asList(* serial1Number),SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "prueba giovanny")

        val series1Format = LineAndPointFormatter(Color.CYAN ,Color.GREEN,Color.CYAN,null)

        plot.addSeries(series1,series1Format)


        plot.graph.getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).format = object : Format(){
            override fun format(
                obj: Any?,
                toAppendTo: StringBuffer?,
                pos: FieldPosition?
            ): StringBuffer {
                val i = Math.round((obj as Number).toFloat())
                return toAppendTo!!.append(domainLabels[i])
            }

            override fun parseObject(source: String?, pos: ParsePosition?): Any? {
           return null
            }
        }

    }

    fun toBringBD(view: android.view.View) {}
}