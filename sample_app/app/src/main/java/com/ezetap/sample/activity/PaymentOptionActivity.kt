package com.ezetap.sample.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.ezetap.sample.R
import kotlinx.android.synthetic.main.r_header.*

class PaymentOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_option)

        initUI()

    }

    private fun initUI() {

        imgCart.visibility = View.GONE
        imgBell.visibility = View.GONE

        val imvUpi = findViewById<ImageView>(R.id.imUpi)
        val data = intent
        val amount = data.getDoubleExtra("productAmount", 0.0)
        imvUpi.setOnClickListener {
            val intent = Intent(this, UpiActivity::class.java)
            intent.putExtra("productAmount", amount)
            startActivity(intent)
        }

    }
}