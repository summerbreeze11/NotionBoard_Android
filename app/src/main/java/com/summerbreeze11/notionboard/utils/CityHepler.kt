package com.summerbreeze11.notionboard.utils

import android.content.Context
import android.util.Log
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import java.util.*


object CityHepler {
    fun getAllRegions(context: Context): ArrayList<String> {
        val arr = arrayListOf<String>()
        var json: String? = null
        try {
            val inputStream: InputStream = context.assets.open("RegionsAndCities.json")
            json = inputStream.bufferedReader().use { it.readText() }

            val jsonArr = JSONArray(json)

            for (i in 0 until jsonArr.length()) {
                val jsonObj = jsonArr.getJSONObject(i)
                arr.add(jsonObj.getString("name"))
            }
        } catch (e: IOException) {
            Log.d("MyLog", "$e")
        }
        return arr
    }

    fun filterListData(list: ArrayList<String>, searchText: String?): ArrayList<String>{
        val tempList = ArrayList<String>()
        tempList.clear()
        if (searchText == null){
            tempList.add("No result")
            return tempList
        }
        for(selection : String in list){
            if (selection.lowercase().startsWith(searchText.lowercase())){
                tempList.add(selection)
            }
        }
        if (tempList.size == 0) tempList.add("No result")
        return tempList
    }
}


