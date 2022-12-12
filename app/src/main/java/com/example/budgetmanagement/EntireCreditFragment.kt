package com.example.budgetmanagement

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.google.android.material.button.MaterialButton
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class EntireCreditFragment : Fragment(), View.OnClickListener {

    private var fragmentView : View? = null
    var datePickBtn : MaterialButton? = null
    var tools: Tools? = null
    val appContext = requireContext().applicationContext


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_entire_credit, container, false)
        tools = Tools(appContext)
        initView()

        return fragmentView
    }

    private fun initView() {
        datePickBtn = (fragmentView as View).findViewById<MaterialButton>(R.id.date_pick)
        (datePickBtn as MaterialButton).setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        val itemId = v?.id
        if (itemId == R.id.date_pick){
            Log.d("Key__", "onclick")
            tools?.getGreetingMsg()

        }

    }




}