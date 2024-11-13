package com.maninmiddle.feature_search.util

import java.text.SimpleDateFormat
import java.util.Locale

fun formatDate(apiDate: String): String? {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(apiDate)
        SimpleDateFormat("d MMMM", Locale("ru")).format(inputFormat!!)
    } catch (e: Exception) {
        null
    }
}