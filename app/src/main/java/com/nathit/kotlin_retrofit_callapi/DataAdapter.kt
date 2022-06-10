package com.nathit.kotlin_retrofit_callapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter (val context: Context, val userList: List<DataModelItem>): RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var uIdTv: TextView = itemView.findViewById(R.id.uIdTv)
        var titleTv: TextView = itemView.findViewById(R.id.titleTv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.uIdTv.text = userList[position].userId.toString()    //รับข้อมูลจาก DataModelItem โดยเลือก userId จาก JSON URL มาแสดงใน TextView(uIdTv) เป็นค่า text และเปลี่ยนค่าจาก Int เป็น String
        holder.titleTv.text = userList[position].title              //รับข้อมูลจาก DataModelItem โดยเลือก title จาก JSON URL มาแสดงใน TextView(titleTv) เป็นค่า text
    }

    override fun getItemCount(): Int {
        return userList.size
    }




}