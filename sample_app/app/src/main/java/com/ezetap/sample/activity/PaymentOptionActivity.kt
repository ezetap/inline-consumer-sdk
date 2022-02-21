package com.ezetap.sample.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.ezetap.sample.R

class PaymentOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_option)
        val imvUpi = findViewById<ImageView>(R.id.imUpi)
        imvUpi.setOnClickListener {
            startActivity(Intent(this, UpiActivity::class.java))
        }
    }
}