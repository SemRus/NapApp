package com.example.napoleonapplication.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.napoleonapplication.Product
import com.example.napoleonapplication.R
import kotlinx.android.synthetic.main.basket_layout.view.*
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(
    private val onDeleteClick: (string:Product) -> Unit
): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var categories: List<Product> = listOf()

    fun setData(categories: MutableList<Product>){
        this.categories = categories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        )


    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        @SuppressLint("SetTextI18n")
        fun bind(text: Product){
            itemView.categoryTv.text = text.title
            itemView.PriceTv.text = "${text.price}р"
            itemView.SaleTv.text = "${text.salePercent}%"

            itemView.deleteIv.setOnClickListener{
                onDeleteClick(text)
            }
        }
    }
}