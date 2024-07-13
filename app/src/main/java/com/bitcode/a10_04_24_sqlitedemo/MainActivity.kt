package com.bitcode.a10_04_24_sqlitedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var i : Int = 0
    var arr : ArrayList<Product> = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var dbUtil = DBUtil(this)
        dbUtil.addProduct(101,"Product101",1001)
        dbUtil.addProduct(102,"Product102",1002)
        dbUtil.addProduct(103,"Product103",1003)

        for (i in 104..110){
            dbUtil.addProduct(i,"Product$i",i * 10)
        }

        arr = dbUtil.retriveProducts()
        for (eachProduct in arr){
            Log.e("tag", "${eachProduct.id} -- ${eachProduct.title} -- ${eachProduct.price}")
        }

        dbUtil.deleteProduct(101)

        for (eachProduct in dbUtil.retriveProducts()){
            Log.e("tag","$eachProduct.id -- ${eachProduct.title} -- ${eachProduct.price}")
        }

        dbUtil.updateProduct(104,"Product180",10080)

        for (eachProduct in dbUtil.retriveProducts()){
            Log.e("tag","${eachProduct.id} -- ${eachProduct.title} -- ${eachProduct.price}")
        }
    }
}