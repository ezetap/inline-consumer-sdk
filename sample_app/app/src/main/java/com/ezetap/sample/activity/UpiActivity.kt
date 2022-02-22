package com.ezetap.sample.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.ezetap.consumerpaymentsdk.activity.ServiceActivity
import com.ezetap.sample.R
import org.json.JSONObject


class UpiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upi)
        val imVEzeUPI = findViewById<ImageView>(R.id.imVEzeUPI)
        imVEzeUPI.setOnClickListener {
            val intent = Intent(this@UpiActivity, ServiceActivity::class.java)
            val  jsonObject = JSONObject()
            jsonObject.put("amount",120.54)
            jsonObject.put("merchantVPA","8310615397@axis")
            jsonObject.put("merchantName","GFoods" )
            jsonObject.put("emailAddress","")
            val data = jsonObject.toString()
            Log.d("UpiActivity" , "data ${data}" )
            intent.putExtra("payData", data)
            //intent.putExtra("deRegister", true)
            startActivityForResult(intent,1234)
        }
    }
}