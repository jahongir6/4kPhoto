package com.example.a4krasmlar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a4krasmlar.RvClick
import com.example.a4krasmlar.databinding.RvLayoutBinding
import com.example.a4krasmlar.utils.RecyclerItemDecoration
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class ViewPagerAdapter(val context: Context, val list: Array<List<Int>>?, val rvClick: RvClick) :
    RecyclerView.Adapter<ViewPagerAdapter.Vh>() {

    inner class Vh(private val rvLayoutBinding: RvLayoutBinding) : RecyclerView.ViewHolder(rvLayoutBinding.root) {
        fun onBind(position: Int) {
            rvLayoutBinding.myRv.layoutManager = GridLayoutManager(context, 3)

            rvLayoutBinding.myRv.adapter = ScaleInAnimationAdapter(RvAdapter(context,list?.get(position) as ArrayList<Int>, rvClick))
            rvLayoutBinding.myRv.addItemDecoration(RecyclerItemDecoration(3, 1))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) = holder.onBind(position)


    override fun getItemCount(): Int = 5


}