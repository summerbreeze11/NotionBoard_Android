package com.summerbreeze11.notionboard.dialogs

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.summerbreeze11.notionboard.R
import com.summerbreeze11.notionboard.utils.CityHepler

class DialogSpinerHelper() {

    @SuppressLint("MissingInflatedId")
    fun showSpinnerDialog(context: Context, list: ArrayList<String>){
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        val rootView = LayoutInflater.from(context).inflate(R.layout.spinner_layout, null)
        val adapter = RcViewDialogSpinnerAdapter(context, dialog)
        val rcView = rootView.findViewById<RecyclerView>(R.id.rcSpView)
        val sv = rootView.findViewById<SearchView>(R.id.svSpinner)
        rcView.layoutManager = LinearLayoutManager(context)
        rcView.adapter = adapter
        dialog.setView(rootView)
        adapter.updateAdapter(list)
        setSearchViewListener(adapter, list, sv)

        dialog.show()
    }

    private fun setSearchViewListener(adapter: RcViewDialogSpinnerAdapter, list: ArrayList<String>, sv: SearchView) {
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val tempList = CityHepler.filterListData(list, newText)
                adapter.updateAdapter(tempList)
                return true
            }
        })

    }


}