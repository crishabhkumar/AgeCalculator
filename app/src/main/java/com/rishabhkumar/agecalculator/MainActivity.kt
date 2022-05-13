package com.rishabhkumar.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    
    lateinit var btnDob : Button
    lateinit var txtDob : TextView
    lateinit var txtAge : TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        btnDob = findViewById(R.id.btnDOB)
        btnDob.setOnClickListener{view->
            //to check button is ok?
            //Toast.makeText(this,"Button clicked.",Toast.LENGTH_LONG).show()
            ageCalculator(view)

        }

    }



    fun ageCalculator(view: View){
    //to check function is working
    //Toast.makeText(this,"Inside function",Toast.LENGTH_SHORT).show()

        var myCalender = Calendar.getInstance()
        var year = myCalender.get(Calendar.YEAR)
        var month = myCalender.get(Calendar.MONTH)
        var day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{
                    view,year,month,day->
                    val selectedDate = "$day/${month+1}/$year"
                    txtDob = findViewById(R.id.txtDOB)
                    txtDob.text = selectedDate
                                              //Toast.makeText(this,"Selected date is $year $month $day",Toast.LENGTH_LONG).show()

                    var dob = Calendar.getInstance()
                    dob.set(year,month,day)

                    var age = myCalender.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
                    if(myCalender.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
                        age--
                    }
                    txtAge = findViewById(R.id.txtAge)
                    txtAge.text = "Your age is $age years old."
                                              },
            year,month,day).show()
    }
}