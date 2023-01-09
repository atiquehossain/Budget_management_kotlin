package com.example.budgetmanagement.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetmanagement.R
import com.example.budgetmanagement.database.DebitDB
import java.lang.String

data class DebitAdapter(private  val debitDB : ArrayList<DebitDB>): RecyclerView.Adapter<DebitAdapter.DebitViewHolder>(){

    private val arrDebitDB: ArrayList<DebitDB> = debitDB


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebitAdapter.DebitViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_recycler_style_ad_follow_up, parent, false)
        return DebitViewHolder(v)

    }



    override fun onBindViewHolder(holder: DebitViewHolder, position: Int) {
        val debitDB : DebitDB = arrDebitDB[position]
        holder.creditSrc.text = String.valueOf(debitDB.creditSrc)
        holder.creditEntryDate.text = String.valueOf(debitDB.creditEntryDate)
        holder.creditAmount.text = String.valueOf(debitDB.creditAmount)
    }



    override fun getItemCount(): Int {
        return arrDebitDB.size
    }

    inner  class DebitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var creditSrc: TextView = itemView.findViewById(R.id.creditSrc)
        var creditEntryDate: TextView = itemView.findViewById(R.id.creditEntryDate)
        var creditAmount: TextView = itemView.findViewById(R.id.creditAmount)


    }

}
