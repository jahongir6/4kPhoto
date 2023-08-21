package com.example.a4krasmlar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.a4krasmlar.R
import com.example.a4krasmlar.RvClick
import com.example.a4krasmlar.databinding.ItemRvBinding
import java.util.ArrayList

class RvAdapter(val context: Context, private val list: ArrayList<Int>, val rvClick: RvClick) :
    RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(private val itemRvBinding: ItemRvBinding) :
        RecyclerView.ViewHolder(itemRvBinding.root) {

        fun onBind(imageId: Int,position: Int) {
            itemRvBinding.imageContainer.setImageResource(imageId)

            itemRvBinding.root.setOnClickListener {
                rvClick.rvItemClicked(imageId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) = holder.onBind(list[position],position)


    override fun getItemCount(): Int = list.size


}