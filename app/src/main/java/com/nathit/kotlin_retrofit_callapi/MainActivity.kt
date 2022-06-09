package com.nathit.kotlin_retrofit_callapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

///TODO BASE_URL
const val BASE_URL = "https://jsonplaceholder.typicode.com"
// const – ใช้สำหรับประกาศค่าตัวแปรที่ไม่ต้องการให้เปลี่ยนแปลงค่าได้
class MainActivity : AppCompatActivity() {

    lateinit var txtId: TextView    //lateinit รับค่า View

    var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtId = findViewById<TextView>(R.id.txtId)

        getData()

    }

    private fun getData() {
        ///TODO getData
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())         //เพิ่มตัวสร้างตัวแปลง Gson
            .baseUrl(BASE_URL)   //ลิงค์ที่อยู่ Url ของตัว Json ที่ต้องการ นำมาแสดงเป็ฯ base
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object: Callback<List<DataModelItem>?> {
            override fun onResponse(call: Call<List<DataModelItem>?>, response: Response<List<DataModelItem>?>) {
                ///TODO onResponse
                val responseBody = response.body()!!
                val stringBuilder = StringBuilder()
                for (data in responseBody) {
                    stringBuilder.append(data.id)
                    stringBuilder.append("\n")
                }

                txtId.text = stringBuilder

            }

            override fun onFailure(call: Call<List<DataModelItem>?>, t: Throwable) {
                ///TODO onFailure
                Log.d(TAG, "onFailure: "+t.message) //แสดง log onFailure
            }
        })
    }


}