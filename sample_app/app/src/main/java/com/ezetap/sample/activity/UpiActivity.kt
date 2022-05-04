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
import com.ezetap.consumerpaymentsdk.utils.Toaster
import com.ezetap.sample.R
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_upi.*
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

            if (etPhoneNumber.text.isNullOrBlank()) {
                Toaster.showLong("Please enter mobile number")
                return@setOnClickListener
            }

            val intent = Intent(this@UpiActivity, ServiceSDKActivity::class.java)
            val  jsonObject = JSONObject()
            jsonObject.put("amount",amount)
            jsonObject.put("merchantVPA","9949858407@axis")
            jsonObject.put("merchantName","Nomi's Boutique" )
            jsonObject.put("userEmailAddress","atif.q@ezetap.com")
            jsonObject.put("merchantSimulatorToken","Nomi's Boutique" )
            jsonObject.put("merchantUUID","ewogICJraWQiIDogImI2YzU2MDc1LTU3ZTItNDI5Ni1hZmI4LWE4NTJkY2M1MzFlNSIsCiAgImFsZyIgOiAiUlMyNTYiLAogICJ0eXAiIDogIkpXVCIKfQ.ewogICJlbWFpbElkIiA6ICJ0ZXN0VXNlckB0ZXN0LmNvbSIsCiAgIm5hbWUiIDogIlRlc3RVc2VyIiwKICAicGhvbmVOdW1iZXIiIDogIjk4MzAwOTgzMDAiLAogICJtZXJjaGFudENvZGUiIDogIklOTElORV9VUElfVEVTVCIsCiAgImlzcyIgOiAiSU5MSU5FX1VQSV9URVNUIiwKICAiaWF0IiA6IDE2NTA5NTUzNjQsCiAgImV4cCIgOiAxNjc2ODc1MzY0Cn0.AEg5UFKmN52TQEuxhy9UoFGls44Gw8ROj8_SFV-3Zb5UKbaOeVBoUrkc4AvTnJEppDDaOhirV-XdqQT9bIkKGwnsAL2oJoIIT7eGBtv6eYWpBVJepd0t608HSKBA2aW_VT7PDLZMsOYqnTAFfTw3juxB2ULEeczzTcHRerOG_ldTD5owFkUn620dxoqBUcGhsv-q2HWww5S0Ul9sPMZGndT5al19b0f3AlfjguIYx58FGsfrQMn7TqOkHN08fchYN-G53pLYVz_msR0Md90yPfy3UHijXhWecgMB7Jh_rHJABTh7ZGH9A9xZUvaNst8l4qGY52L1EAHaxUQ_PDbD1w")
            jsonObject.put("phoneNumber", etPhoneNumber.text.toString())
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