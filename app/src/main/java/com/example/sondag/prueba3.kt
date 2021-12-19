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

        val domainLabels = arrayOf<Number>(1,2,3,6,7,8,9,10,13,14)
        val serial1Number = arrayOf<Number>(1,4,8,12,16,32,26,29,10,13)

        val series1: XYSeries=SimpleXYSeries(Arrays.asList(* serial1Number),SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series 1")

        val series1Format = LineAndPointFormatter(Color.BLUE,Color.BLACK,null,null)

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
}