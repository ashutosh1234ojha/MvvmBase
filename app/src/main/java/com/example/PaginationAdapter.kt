package com.example

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmbase.R
import kotlinx.android.synthetic.main.item_pb.view.*
import kotlinx.android.synthetic.main.rv_item.view.*


 class PaginationAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var   list: List<String>?=null
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv = view.tv

    }

    class ProgressViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val progressBar = view.progressBar

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder{
        // create a new view
        var vh: RecyclerView.ViewHolder

        if(viewType==0){
            val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item, parent, false) as View

            vh =  MyViewHolder(textView);

        }else{
            val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pb, parent, false) as View

            vh =  ProgressViewHolder(textView);

        }
        return    vh

    }

    override fun getItemCount(): Int {

        if(list!=null){
            return  list!!.size
        }
        return 0
    }

    override fun getItemViewType(position: Int): Int {
        return if (list!!.get(position) != "P") 0 else 1

    }

    fun setValue( list: List<String>){

        this.list=list
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(holder is ProgressViewHolder){

            holder.progressBar.isIndeterminate = true
            // holderas.tv.text=list!![position]

            Log.d("Position",list!![position])

        }else{


            (holder as MyViewHolder).tv.text=list!![position]

          //  (holder as ProgressViewHolder).progressBar.setIndeterminate(true)


        }


    }
}