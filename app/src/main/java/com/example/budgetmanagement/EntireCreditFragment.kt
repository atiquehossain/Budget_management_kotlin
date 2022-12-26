package com.example.budgetmanagement

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.budgetmanagement.database.AppDatabase
import com.example.budgetmanagement.database.CreditsDB
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class EntireCreditFragment : Fragment(), View.OnClickListener {

    private  var appDb : AppDatabase? = null
    private var fragmentView : View? = null
    var tools: Tools? = null

    var tempDate: String? = null
    var datePickBtn : MaterialButton? = null
    var creditAddBtn : MaterialButton? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_entire_credit, container, false)
        tools = Tools(context)
        appDb = AppDatabase.getDatabase(requireContext())

        initView()

        return fragmentView
    }

    private fun initView() {
        datePickBtn = (fragmentView as View).findViewById<MaterialButton>(R.id.date_pick)
        (datePickBtn as MaterialButton).setOnClickListener(this)
        creditAddBtn = (fragmentView as View).findViewById<MaterialButton>(R.id.add_credit)
        (creditAddBtn as MaterialButton).setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        val itemId = v?.id
        if (itemId == R.id.date_pick){
            tempDate =  tools?.datePick()
            datePickBtn?.setText(tempDate)

        }
        if (itemId == R.id.add_credit){
            val mEditCredit = (fragmentView as View).findViewById<EditText>(R.id.creditId)
            val mEditCreditSrc = (fragmentView as View).findViewById<EditText>(R.id.creditSrcId)
           // Toast.makeText(context, mEditText.text.toString(), Toast.LENGTH_SHORT).show()

            val creditDb = CreditsDB(null,mEditCreditSrc.text.toString(),tempDate!!,mEditCredit.text.toString().toInt(),0)
            GlobalScope.launch(Dispatchers.IO) {
                appDb?.creditDao()?.insert(creditDb)
            }
            Toast.makeText(context,"Successfully written",Toast.LENGTH_SHORT).show()


        }

    }




}