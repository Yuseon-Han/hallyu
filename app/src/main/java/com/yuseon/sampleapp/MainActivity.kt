package com.yuseon.sampleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yuseon.mylibrary.view.util.LinearPagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_item.view.*

class MainActivity : AppCompatActivity() {
    companion object {
        private const val imageUrl = "https://picsum.photos/200/300?random="
        private const val imageCnt = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setView()
    }

    private fun setView() {
        with(recyclerview) {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = MyAdapter()
            adapter?.notifyDataSetChanged()

//            LinearSnapHelper().attachToRecyclerView(this)

//            PagerSnapHelper().attachToRecyclerView(this)

            LinearPagerSnapHelper(LinearPagerSnapHelper.Gravity.LEFT)
                .attachToRecyclerView(this)
        }
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(position: Int) {
            itemView.item_text.text = "$position"

            Glide.with(itemView.context.applicationContext)
                .load("$imageUrl$position")
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(itemView.item_image)
        }
    }

    class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false))
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bindView(position)
        }

        override fun getItemCount(): Int {
            return imageCnt
        }
    }
}

