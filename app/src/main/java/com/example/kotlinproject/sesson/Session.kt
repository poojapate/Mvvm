package com.example.kotlinproject.sesson

import android.content.Context
import android.content.SharedPreferences

class Session(context: Context) {

    private val fileName = "userData"
    private val userPass = "userPass"
    private val userId = "userId"


    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()


    fun setUserId(name: String) {
        editor.putString(userId, name).apply()

    }

    fun getUserId(): String {
        return sharedPreferences.getString(userId, "") ?: ""

    }


}