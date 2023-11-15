package com.rnnativemodule.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.rnnativemodule.R


class RecyclerAdapter(private val context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recyclist, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(FitCenter(), RoundedCorners(16))
        Glide.with(context)
            .load("https://openai.com/content/images/2021/01/2x-no-mark-1.jpg")
            .apply(requestOptions)
            .skipMemoryCache(true)//for caching the image url in case phone is offline
            .into(viewHolder.img_android)

    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var img_android: ImageView

        init {
            img_android =
                view.findViewById<View>(R.id.iv_glide) as ImageView
        }
    }
}