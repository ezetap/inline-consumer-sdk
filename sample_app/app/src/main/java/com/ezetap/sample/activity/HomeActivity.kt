package com.ezetap.sample.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ezetap.sample.R
import com.ezetap.sample.adapter.ProductAdapter
import com.ezetap.sample.model.Product

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = GridLayoutManager(this ,2)
        val data = getProducts()
        val adapter = ProductAdapter(data ,  this@HomeActivity)
        recyclerview.adapter = adapter
        /*initOliveListener()
        iv_notif?.setOnClickListener { OliveUpiManager.getInstance(this@HomeActivity).deRegister() }
*/

    }


    private fun getProducts(): List<Product> {

        var products = mutableListOf<Product>()
        products.add(Product(
            1,
            R.drawable.product1 ,
            "Kanjeevaram Saree",
            "Vivacious colors, royal borders",
            "Very nice products",
        1256.98

        ))

        products.add(Product(
            2,
            R.drawable.product2 ,
            "Nauvari Saree",
            "Originating from the west coast",
            "Very nice products",
            2056.34

        ))
        products.add(Product(
            3,
            R.drawable.product3 ,
            "Bandhani Saree",
            "Nauvari sarees are styled",
            "Very nice products",
            3256.12

        ))
        products.add(Product(
            4,
            R.drawable.product4 ,
            "Tant Saree",
            "Saree is a staple in every Bengali",
            "Very nice products",
            9256.64

        ))
        products.add(Product(
            5,
            R.drawable.product5 ,
            "Banarsi Saree",
            "Banarsi saree was crafted",
            "Very nice products",
            6256.43

        ))
        products.add(Product(
            6,
            R.drawable.product6 ,
            "Chikankari Saree",
            "Nawabi city of Lucknow",
            "Very nice products",
            3256.24

        ))
        return products

    }

    fun itemClick(product: Product,
        homeActivity: HomeActivity) {
        val intent = Intent(homeActivity, ProductDetailActivity::class.java)
        intent.putExtra("productImage", product.productImage)
        intent.putExtra("productName", product.productName)
        intent.putExtra("productShortDescp", product.productShortDescription)
        intent.putExtra("productAmount", product.productAmount)
        startActivity(intent)

    }
}