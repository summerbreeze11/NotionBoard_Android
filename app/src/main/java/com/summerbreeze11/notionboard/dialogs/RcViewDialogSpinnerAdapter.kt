package com.summerbreeze11.notionboard.dialogs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.summerbreeze11.notionboard.R
import com.summerbreeze11.notionboard.activity.EditAdsAct

class RcViewDialogSpinnerAdapter(var context: Context, var dialog:android.app.AlertDialog): RecyclerView.Adapter<RcViewDialogSpinnerAdapter.SpViewHolder>() {
    private val mainList = ArrayList<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sp_list_item, parent, false)
        return SpViewHolder(view, context, dialog)
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    override fun onBindViewHolder(holder: SpViewHolder, position: Int) {
        holder.setData(mainList[position])
    }

    class SpViewHolder(itemView: View, var cont: Context, var dialog: android.app.AlertDialog) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var itemText = ""
        fun setData(text: String){
            val tvSpItem = itemView.findViewById<TextView>(R.id.tvSpItem)
            tvSpItem.text = text
            itemText = text
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            (cont as EditAdsAct).binding.tvCity.text = itemText
            dialog.dismiss()
        }

    }

    fun updateAdapter(list: ArrayList<String>){
        mainList.clear()
        mainList.addAll(list)
        notifyDataSetChanged()
    }
}