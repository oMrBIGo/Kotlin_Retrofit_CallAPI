package com.nathit.kotlin_retrofit_callapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

///TODO BASE_URL
const val BASE_URL = "https://jsonplaceholder.typicode.com"

// const – ใช้สำหรับประกาศค่าตัวแปรที่ไม่ต้องการให้เปลี่ยนแปลงค่าได้
class MainActivity : AppCompatActivity() {

    lateinit var dataAdapter: DataAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var rv: RecyclerView


    var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)
        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager

        getData()

    }

    private fun getData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())         //เพิ่มตัวสร้างตัวแปลง Gson
            .baseUrl(BASE_URL)   //ลิงค์ที่อยู่ Url ของตัว Json ที่ต้องการ นำมาแสดงเป็ฯ base
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<DataModelItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<DataModelItem>?>,
                response: Response<List<DataModelItem>?>
            ) {
                val responseBody = response.body()!!
                dataAdapter = DataAdapter(baseContext, responseBody)
                dataAdapter.notifyDataSetChanged()
                rv.adapter = dataAdapter
            }

            override fun onFailure(call: Call<List<DataModelItem>?>, t: Throwable) {
                d(TAG, "onFailure: " + t.message) //แสดง log onFailure
            }
        })
    }

}