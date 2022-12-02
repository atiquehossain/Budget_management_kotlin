package com.example.budgetmanagement

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton


class HomeFragment : Fragment(),  View.OnClickListener{

    private var helloTv: TextView? = null
    private var fragmentView : View? = null
    private var Mhistory : MaterialButton? = null
    private var Mpay : MaterialButton? = null
    private var Maddbtn : MaterialButton? = null
    private var Mtodo : MaterialButton? = null
    private var Maccount : MaterialButton? = null
    private var Msend : MaterialButton? = null
    private var MAnalysis : MaterialButton? = null
    private var Mpdf : MaterialButton? = null
    private var Mreset : MaterialButton? = null
    private var greeting : String? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_home, container, false)
        initView()
        return fragmentView
    }

    private fun initView() {
        greeting = arguments?.getString("greeting")
        helloTv = (fragmentView as View).findViewById<TextView>(R.id.hello)
        (helloTv as TextView).setText(greeting)



        Maddbtn = (fragmentView as View).findViewById<MaterialButton>(R.id.add_btn)
        (Maddbtn as MaterialButton).setOnClickListener(this)
        Mpay = (fragmentView as View).findViewById<MaterialButton>(R.id.expend)
        (Mpay as MaterialButton).setOnClickListener(this)
        Mhistory = (fragmentView as View).findViewById<MaterialButton>(R.id.loHistory)
        (Mhistory as MaterialButton).setOnClickListener(this)
        Mtodo = (fragmentView as View).findViewById<MaterialButton>(R.id.Mtodo)
        (Mtodo as MaterialButton).setOnClickListener(this)
        Maccount = (fragmentView as View).findViewById<MaterialButton>(R.id.Maccount)
        (Maccount as MaterialButton).setOnClickListener(this)
        Msend = (fragmentView as View).findViewById<MaterialButton>(R.id.Msend)
        (Msend as MaterialButton).setOnClickListener(this)
        MAnalysis = (fragmentView as View).findViewById<MaterialButton>(R.id.MAnalysis)
        (MAnalysis as MaterialButton).setOnClickListener(this)
        Mpdf = (fragmentView as View).findViewById<MaterialButton>(R.id.Mpdf)
        (Mpdf as MaterialButton).setOnClickListener(this)
        Mreset = (fragmentView as View).findViewById<MaterialButton>(R.id.Mreset)
        (Mreset as MaterialButton).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val itemId = v?.id
        if (itemId == R.id.loHistory){
            Log.d("Atique", "onClick: ")
        }
    }


}