package com.singpaulee.sandec.monthlypointofsale.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.Display

class SharedPrefManager(context: Context) {
    val PREFNAME:String = "possandec"
    val ID:String = "id"
    val NAMA:String = "nama"
    val USERNAME:String = "username"
    val SUDAHLOGIN:String = "sudahlogin"

    lateinit var context:Context
    lateinit var pref:SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    init {
        this.context = context
        pref = context.getSharedPreferences(PREFNAME, 0)
        editor = pref.edit()
    }

    fun savePrefString(nama:String , value:String){
        editor.putString(nama, value)
        editor.commit()
        Log.d("PREFERENCE", "Pref $nama Save $value")
    }

    fun savePrefInt(nama:String , value:Int){
        editor.putInt(nama, value)
        editor.commit()
        Log.d("PREFERENCE", "Pref $nama Save $value")
    }

    fun savePrefBoolean(nama:String , value:Boolean){
        editor.putBoolean(nama, value)
        editor.commit()
        Log.d("PREFERENCE", "Pref $nama Save $value")
    }

    fun getId(): String {
        return pref.getString(ID, "")
    }

    fun getNama(): String {
        return pref.getString(NAMA, "")
    }

    fun getUsername() : String {
        return pref.getString(USERNAME, "")
    }

    fun getSudahLogin() : Boolean {
        return pref.getBoolean(SUDAHLOGIN,false)
    }
}