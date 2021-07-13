package com.example.examencurp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerSexo = findViewById<Spinner>(R.id.spinnerSexo)
        val valueSexo =  arrayOf("Hombre", "Mujer")
        val arraySexo = ArrayAdapter(this,android.R.layout.simple_spinner_item,valueSexo)
        spinnerSexo.adapter = arraySexo

        val spinnerEstado = findViewById<Spinner>(R.id.spinnerEstado)
        val valueEstado =  arrayOf("AS-Aguascalientes", "BC-Baja California", "BS-Baja California Sur",
            "CC-Campeche", "CS-Chiapas", "CH-Chihuahua", "DF-Ciudad de México", "CL-Coahuila",
            "CM-Colima", "DG-Durango", "GT-Guanajuato", "GR-Guerrero", "HG-Hidalgo", "JC-Jalisco",
            "MC-México", "MN-Michoacán","MS-Morelos","NT-Nayarit","NL-Nuevo León","OC-Oaxaca",
            "PL-Puebla","QO-Querétaro","QR-Quintana Roo","SP-San Luis Potosí","SL-Sinaloa",
            "SR-Sonora","TC-Tabasco","TS-Tamaulipas","TL-Tlaxcala","VZ-Veracruz","YN-Yucatan","ZS-Zacatecas")
        val arrayEstado = ArrayAdapter(this,android.R.layout.simple_spinner_item,valueEstado)
        spinnerEstado.adapter = arrayEstado

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
        val sexoValue = spinnerSexo.selectedItem.toString()
        val estadoValue = spinnerEstado.selectedItem.toString()

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

        val arrayName = nombreValue.drop(1).split("")
        val consonanteName = arrayName.find {it.equals("b")||it.equals("c")||it.equals("d")||it.equals("f")
                ||it.equals("g")||it.equals("h")||it.equals("j")||it.equals("k")||it.equals("l")
                ||it.equals("m")||it.equals("n")||it.equals("ñ")||it.equals("p")||it.equals("q")
                ||it.equals("r")||it.equals("s")||it.equals("t")||it.equals("v")||it.equals("w")
                ||it.equals("x")||it.equals("y")||it.equals("z")}
        var consonanteNombre = consonanteName.toString().toUpperCase()

        val arrayApellidoP = apellidopValue.drop(1).split("")
        var consonanteApeP = arrayApellidoP.find {it.equals("b")||it.equals("c")||it.equals("d")||it.equals("f")
                ||it.equals("g")||it.equals("h")||it.equals("j")||it.equals("k")||it.equals("l")
                ||it.equals("m")||it.equals("n")||it.equals("ñ")||it.equals("p")||it.equals("q")
                ||it.equals("r")||it.equals("s")||it.equals("t")||it.equals("v")||it.equals("w")
                ||it.equals("x")||it.equals("y")||it.equals("z")}
        var consonantePaterno = consonanteApeP.toString().toUpperCase()

        val arrayApellidoM = apellidomValue.drop(1).split("")
        var consonanteApeM = arrayApellidoM.find {it.equals("b")||it.equals("c")||it.equals("d")||it.equals("f")
                ||it.equals("g")||it.equals("h")||it.equals("j")||it.equals("k")||it.equals("l")
                ||it.equals("m")||it.equals("n")||it.equals("ñ")||it.equals("p")||it.equals("q")
                ||it.equals("r")||it.equals("s")||it.equals("t")||it.equals("v")||it.equals("w")
                ||it.equals("x")||it.equals("y")||it.equals("z")}
        var consonanteMaterno = consonanteApeM.toString().toUpperCase()

        var curp = findViewById<TextView>(R.id.txtRFC)
        curp.text = arrayApep[1].toUpperCase() + segundavocal + arrayApem[1].toUpperCase() + arrayNombre[1].toUpperCase() + arrayYear[3]+ arrayYear[4] +
                mesValue + diaValue + sexoValue[0] + estadoValue[0] + estadoValue[1] + consonantePaterno + consonanteMaterno + consonanteNombre +homo1 + homo2 + homo3
    }

    fun limpiar(view: View) {
        txtNombre.text.clear()
        txtApellidop.text.clear()
        txtApellidom.text.clear()
        spinnerDia.setSelection(0)
        spinnerMes.setSelection(0)
        spinnerYear.setSelection(0)
        spinnerSexo.setSelection(0)
        spinnerEstado.setSelection(0)
        txtRFC.text = ""
    }
}