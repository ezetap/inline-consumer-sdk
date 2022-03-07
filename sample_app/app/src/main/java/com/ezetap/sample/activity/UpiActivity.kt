package com.ezetap.sample.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatButton
import com.ezetap.consumerpaymentsdk.activity.ServiceSDKActivity
import com.ezetap.sample.R
import kotlinx.android.synthetic.main.r_header.*
import org.json.JSONObject


class UpiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upi)

        imgCart.visibility = View.GONE
        imgBell.visibility = View.GONE

        val imVEzeUPI = findViewById<ImageView>(R.id.imVEzeUPI)
        val deRegistration = findViewById<AppCompatButton>(R.id.deRegistration)
        val data = intent
        val amount = data.getDoubleExtra("productAmount", 0.0)
        imVEzeUPI.setOnClickListener {
            val intent = Intent(this@UpiActivity, ServiceSDKActivity::class.java)
            val  jsonObject = JSONObject()
            jsonObject.put("amount",amount)
            jsonObject.put("merchantVPA","saikiran@axis")
            jsonObject.put("merchantName","Nomi's Boutique" )
            jsonObject.put("emailAddress","")
            val data = jsonObject.toString()
            Log.d("UpiActivity" , "data ${data}" )
            intent.putExtra("payData", data)
            startActivityForResult(intent,1234)
        }

        deRegistration.setOnClickListener {
            val intent = Intent(this@UpiActivity, ServiceSDKActivity::class.java)
            intent.putExtra("deRegister", true)
            startActivityForResult(intent,1234)
        }
    }
}