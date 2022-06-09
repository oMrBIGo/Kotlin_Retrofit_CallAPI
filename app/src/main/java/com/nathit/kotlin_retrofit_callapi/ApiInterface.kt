package com.nathit.kotlin_retrofit_callapi

import retrofit2.Call

interface ApiInterface {
    fun getData(): Call<List<DataModelItem>>    //เรียกใช้ DataModelItem มาแสดงเป็น List
}