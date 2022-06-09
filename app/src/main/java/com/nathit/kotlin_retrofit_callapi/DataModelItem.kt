package com.nathit.kotlin_retrofit_callapi

import com.google.gson.annotations.SerializedName

data class DataModelItem(   //[Link: https://jsonplaceholder.typicode.com/posts]
    @SerializedName("body") //แก้ปัญหาเรื่อง Key ใน JSON ไม่ตรงกับชื่อของตัวแปรใน Object
    // เพราะว่าวิธีการตั้งชื่อของทั้งสองอย่างนั้นไม่เหมือนกันหรืออยากจะเปลี่ยนเป็นชื่ออื่นเลยก็ทำได้เช่นกัน
    // [Link: https://akexorcist.dev/serialized-name-in-gson-with-proguard/]
    val body: String,   //ดึงข้อมูล body ที่มี value เป็น String จาก JSON [จำลอง JSON]
    val id: Int,        //ดึงข้อมูล id ที่มี value เป็น Int จาก JSON [จำลอง JSON]
    val title: String,  //ดึงข้อมูล title ที่มี value เป็น String จาก JSON [จำลอง JSON]
    val userId: Int     //ดึงข้อมูล userId ที่มี value เป็น Int จาก JSON [จำลอง JSON]

    //var = final ใน java

)