package com.bitcode.a10_04_24_sqlitedemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ProductsDBHelper(context : Context?,
                       name : String?,
                       factory : SQLiteDatabase.CursorFactory?,
                        version : Int):
    SQLiteOpenHelper(context,name,factory, version){
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table products(id integer primary key, title text NOT NULL, price integer)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}