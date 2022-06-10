package com.nathit.kotlin_retrofit_callapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")   // https://jsonplaceholder.typicode.com/[posts] <-
    fun getData(): Call<List<DataModelItem>>    //เรียกใช้ DataModelItem มาแสดงเป็น List
}