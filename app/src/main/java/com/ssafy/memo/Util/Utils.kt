package com.ssafy.memo.Util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {
    fun getTime():String{
        val date = Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val formatted = formatter.format(date)
        return formatted
    }
}