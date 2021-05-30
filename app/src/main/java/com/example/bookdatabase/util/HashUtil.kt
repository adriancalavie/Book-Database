package com.example.bookdatabase.util

import java.util.*

object HashUtil {
    private const val filtered = " :;,.!?<>()[]\\/{}`'\"~@#$%^&*-+="

    fun makeKey(string: String): String {
        return string.toLowerCase(Locale.ROOT).filterNot { filtered.indexOf(it) > -1 }
    }
}