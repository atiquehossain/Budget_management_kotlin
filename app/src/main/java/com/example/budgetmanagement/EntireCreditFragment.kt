package com.example.budgetmanagement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetmanagement.database.AppDatabase
import com.example.budgetmanagement.database.CreditDao
import com.example.budgetmanagement.database.DebitDB
import com.example.budgetmanagement.recycler.DebitAdapter
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class EntireCreditFragment : Fragment(), View.OnClickListener {

    private  var appDb : AppDatabase? = null
    private var fragmentView : View? = null
    private var tools: Tools? = null

    private var tempDate: String? = null
    private var datePickBtn : MaterialButton? = null
    private var creditAddBtn : MaterialButton? = null

    //recycler
    private lateinit var  debitAdapter: DebitAdapter
    private lateinit var  creditDao: CreditDao
    private lateinit var  recyclerView: RecyclerView
    private lateinit var  arrDebitDB: ArrayList<DebitDB>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_entire_credit, container, false)
        tools = Tools(context)
        appDb = AppDatabase.getDatabase(requireContext())

        initView()

        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        //val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.mRecyclerView)
        recyclerView.setHasFixedSize(true)
        debitAdapter = DebitAdapter(arrDebitDB)
        recyclerView.adapter = debitAdapter
        val adapter = DebitAdapter(arrDebitDB)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Get a new or existing ViewModel from the ViewModelProvider.
        //creditDao = ViewModelProvider(this).get(CreditDao::class.java)
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

            val debitDB = DebitDB(null,mEditCreditSrc.text.toString(),tempDate!!,mEditCredit.text.toString().toInt(),0)
            GlobalScope.launch(Dispatchers.IO) {
                appDb?.creditDao()?.insert(debitDB)
            }
            Toast.makeText(context,"Successfully written",Toast.LENGTH_SHORT).show()

        }

    }



    private  fun dataInitialize(){

        arrDebitDB = arrayListOf<DebitDB>()

    }

    companion object {
        var a = 1
    }

    override fun onResume() {
        super.onResume()


        if (a == 1) {

        }
    }




}