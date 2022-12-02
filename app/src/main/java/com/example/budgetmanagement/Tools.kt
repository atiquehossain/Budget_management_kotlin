package com.example.budgetmanagement

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
}