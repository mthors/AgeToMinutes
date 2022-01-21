package com.mtsthor.umurkemenit

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePicked = findViewById<Button>(R.id.btnDatePicker)
        datePicked.setOnClickListener { View -> clickDatePicker(View)
             }
    }


    fun clickDatePicker(view: View){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{
                    view,selectedYear,selectedMonth,selectedDay ->
                Toast.makeText(this, "button works", Toast.LENGTH_SHORT).show()
                                              val selectDate = "$selectedDay/${selectedMonth+1}/$selectedYear"
                                                val selectedDate = findViewById<TextView>(R.id.pickedDate)
                                                selectedDate.setText(selectDate)
                                                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                                                val theDate = sdf.parse(selectDate)
                                                val selectedDateInMinutes = theDate!!.time / 60000
                                                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                                                val currentDateInMinutes = currentDate!!.time / 60000
                                                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                                                val dateInMinutes = findViewById<TextView>(R.id.ageInMinutes)
                                                dateInMinutes.setText("You are ${differenceInMinutes.toString()} minutes old")
                                              },year,month,day).show()

    }
}