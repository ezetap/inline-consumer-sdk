package com.ezetap.sample.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.ezetap.sample.R

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        intiView()

    }

    private fun intiView() {
        var productImage = findViewById<ImageView>(R.id.productImage)
        var productName = findViewById<TextView>(R.id.productName)
        var productShortDescp = findViewById<TextView>(R.id.productShortDescp)
        var productAmount = findViewById<TextView>(R.id.productAmount)
        val data = intent

        productImage.setImageResource(data.getIntExtra("productImage", R.drawable.product1))
        productName.text = data.getStringExtra("productName")
        productShortDescp.text = data.getStringExtra("productShortDescp")
        productAmount.text = "₹ ${data.getDoubleExtra("productAmount", 0.0)}"

        val pay = findViewById<RelativeLayout>(R.id.pay)
        pay.setOnClickListener {
            startActivity(Intent(this, PaymentOptionActivity::class.java))
        }
    }
}