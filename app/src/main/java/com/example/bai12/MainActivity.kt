package com.example.bai12

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.Time
import android.widget.DatePicker
import com.example.bai12.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {


    val today = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val startHour = today.get(Calendar.HOUR_OF_DAY)
        val startMin = today.get(Calendar.MINUTE)
        lateinit var hour :String
        lateinit var min:String
        lateinit var mont_h :String
        lateinit var dat_e:String
        val date = today.get(Calendar.DATE)
        val year = today.get(Calendar.YEAR)
        val month = today.get(Calendar.MONTH)
        binding.txtDate.text = "$date/${month+1}/$year"
        binding.txtTime.text = "$startHour:$startMin"
        binding.btnTime.setOnClickListener{
            TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

                if(hourOfDay<10) {
                  hour = "0"+ hourOfDay.toString()
                } else {
                    hour = hourOfDay.toString()
                }
                if(hourOfDay<10) {
                    min = "0"+ minute.toString()
                } else
                {
                    min = minute.toString()
                }
                binding.txtTime.text ="$hour:$min"
            },startHour,startMin,true).show()
        }

        binding.btnDate.setOnClickListener{
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                if(month<10) {
                   mont_h = "0"+ (month+1).toString()
                } else {
                    mont_h = (month+1).toString()
                }
                if(dayOfMonth<10) {
                    dat_e = "0"+ dayOfMonth.toString()
                } else
                {
                    dat_e = dayOfMonth.toString()
                }
                binding.txtDate.text = "$dat_e/$mont_h/$year"
            },year,month,date).show()
        }
    }
}