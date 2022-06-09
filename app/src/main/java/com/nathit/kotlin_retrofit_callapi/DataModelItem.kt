package com.nathit.kotlin_retrofit_callapi

data class DataModelItem(   //[Link: https://jsonplaceholder.typicode.com/posts]
    val body: String,   //ดึงข้อมูล body ที่มี value เป็น String จาก JSON [จำลอง JSON]
    val id: Int,        //ดึงข้อมูล id ที่มี value เป็น Int จาก JSON [จำลอง JSON]
    val title: String,  //ดึงข้อมูล title ที่มี value เป็น String จาก JSON [จำลอง JSON]
    val userId: Int     //ดึงข้อมูล userId ที่มี value เป็น Int จาก JSON [จำลอง JSON]
)