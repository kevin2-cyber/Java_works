package com.codelab.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.codelab.ageinminutes.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
        }


        // supportActionBar?.hide()
    }

    private fun clickDatePicker(view: View) {
        val myCalendar: Calendar = Calendar.getInstance()
        val year: Int = myCalendar.get(Calendar.YEAR)
        val month: Int = myCalendar.get(Calendar.MONTH)
        val day: Int = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, // DatePickerDialog.OnDateSetListener
        {
                _, selectedYear, selectedMonth, selectedDayOfMonth ->
            Toast.makeText(this,
                "The chosen year is $selectedYear, the month is $selectedMonth and the day is $selectedDayOfMonth",
                Toast.LENGTH_LONG).show()

            val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"

            binding.tvSelectedDate.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)
        }
            ,year
            ,month
            ,day).show()
    }
}