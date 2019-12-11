package com.example.retrofitdemo.Model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import kotlinx.android.synthetic.main.single_item.view.*

class DataAdapter(dataList:List<Android>): RecyclerView.Adapter<DataAdapter.MyViewholder>() {
    var items=dataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        return MyViewholder(LayoutInflater.from(parent.context).inflate(R.layout.single_item,null))

    }

    override fun getItemCount(): Int {

       return items.size
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        holder.bind(items[position],position)
    }

    class MyViewholder(view : View):RecyclerView.ViewHolder(view){

        val txt_name=view.txt_name
        val txt_api_level=view.txt_api_level
        val txt_version=view.txt_version

        fun bind(android: Android,position: Int) {

            if(position==1)
            {
                txt_name.text = "yo"
                txt_api_level.text ="mama"
                txt_version.text="a skunk"
            }
            else {
                txt_name.text = android.name
                txt_api_level.text = android.apiLevel
                txt_version.text = android.version
            }
        }
    }
}