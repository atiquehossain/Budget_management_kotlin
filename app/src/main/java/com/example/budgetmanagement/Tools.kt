package com.example.budgetmanagement

import android.app.DatePickerDialog
import android.content.Context
import java.util.*

class Tools {
    var context: Context? = null
    var tempStr : String? = null

    constructor(context: Context?) {
        this.context = context
    }

        public fun getGreetingMsg() : String? {
        val c: Calendar = Calendar.getInstance()
        val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)

        if (timeOfDay in 0..11) {
            tempStr = "Good Morning"
        } else if (timeOfDay in 12..15) {
            tempStr = "Good Afternoon"
        } else if (timeOfDay in 16..20) {
            tempStr = "Good Evening"

        } else if (timeOfDay in 21..24) {
            tempStr = "Good Night"
        }
        return tempStr
    }

    public fun datePick() : String?{
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = context?.let {
            DatePickerDialog(
                it,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in textbox
                    //  date_pick.setText("" + dayOfMonth + " " + MONTHS[monthOfYear] + ", " + year)
                    // datePickBtn?.setText("$dayOfMonth/$monthOfYear/$year")
                    tempStr = "$dayOfMonth/$monthOfYear/$year";

                },
                year,
                month,
                day
            )
        }

        if (dpd != null) {
            dpd.show()
        }

        return tempStr;

    }
}