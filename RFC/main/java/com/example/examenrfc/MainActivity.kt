package com.example.examenrfc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerMes = findViewById<Spinner>(R.id.spinnerMes)
        val valueMes =  arrayOf("01","02","03","04","05","06","07","08","09","10","11","12")
        val arrayMes = ArrayAdapter(this,android.R.layout.simple_spinner_item,valueMes)
        spinnerMes.adapter = arrayMes

        val spinnerDia = findViewById<Spinner>(R.id.spinnerDia)
        val valueDia =  arrayOf("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31")
        val arrayDia = ArrayAdapter(this,android.R.layout.simple_spinner_item,valueDia)
        spinnerDia.adapter = arrayDia

        val year = ArrayList<String>()
        for (i in 1950 until 2020){
            year.add(i.toString())
        }
        val spinnerYear = findViewById<Spinner>(R.id.spinnerYear)
        val arrayYear = ArrayAdapter(this,android.R.layout.simple_spinner_item,year)
        spinnerYear.adapter = arrayYear

    }

    fun generar(view: View) {
        val nombreValue = txtNombre.text.toString()
        val apellidopValue = txtApellidop.text.toString()
        val apellidomValue = txtApellidom.text.toString()
        val diaValue = spinnerDia.selectedItem.toString()
        val mesValue = spinnerMes.selectedItem.toString()
        val yearValue = spinnerYear.selectedItem.toString()

        val arrayApep = apellidopValue.split("")
        val arrayApem = apellidomValue.split("")
        val arrayNombre = nombreValue.split("")
        val arrayYear = yearValue.split("")

        //Homoclave
        val homoclave = arrayOf("1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L",
                "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
        val homo1 = homoclave.random()
        val homo2 = homoclave.random()
        val homo3 = homoclave.random()

        //Segunda vocal
        val segundaVocal = arrayApep.find{it.equals("a")||it.equals("e")||it.equals("i")||it.equals("o")||it.equals("u")}
        val segundavocal = segundaVocal.toString().toUpperCase()

        var rfc = findViewById<TextView>(R.id.txtRFC)
        rfc.text = arrayApep[1].toUpperCase() + segundavocal + arrayApem[1].toUpperCase() + arrayNombre[1].toUpperCase() + arrayYear[3]+ arrayYear[4] +
                mesValue + diaValue + homo1 + homo2 + homo3
    }

    fun limpiar(view: View) {
        txtNombre.text.clear()
        txtApellidop.text.clear()
        txtApellidom.text.clear()
        spinnerDia.setSelection(0)
        spinnerMes.setSelection(0)
        spinnerYear.setSelection(0)
        txtRFC.text = ""
    }
}