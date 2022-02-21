package com.ezetap.sample.adapter

/**
 * Created by Atif Qamar on 2/1/22.
 */

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ezetap.sample.R
import com.ezetap.sample.activity.HomeActivity
import com.ezetap.sample.model.Product

class ProductAdapter(
    private val mList: List<Product>,
    private val homeActivity: HomeActivity
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_view, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = mList[position]
        holder.productImage.setImageResource(product.productImage)
        holder.productName.text = product.productName
        holder.productShortDescp.text = product.productShortDescription
        holder.productAmount.text = "₹ ${product.productAmount}"
        holder.cardView.setOnClickListener(View.OnClickListener {

            homeActivity.itemClick(product , homeActivity)
        })
    }


    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productShortDescp: TextView = itemView.findViewById(R.id.productShortDescp)
        val productAmount: TextView = itemView.findViewById(R.id.productAmount)
        val cardView : CardView = itemView.findViewById(R.id.cardView)
    }

}
