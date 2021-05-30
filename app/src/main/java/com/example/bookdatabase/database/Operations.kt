package com.example.bookdatabase.database

import android.app.Activity
import android.util.Log
import com.example.bookdatabase.adapters.RvAdapter
import com.example.bookdatabase.interfaces.IActivityFragmentCommunication
import com.example.bookdatabase.models.Book
import com.example.bookdatabase.util.HashUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList


class Operations {


    companion object {
        @JvmField
        val database =
            Firebase.database("https://book-database-6d27b-default-rtdb.europe-west1.firebasedatabase.app/").reference

        const val TAG: String = "Operations"
    }
}