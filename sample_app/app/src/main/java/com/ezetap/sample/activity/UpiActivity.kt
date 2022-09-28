package com.ezetap.sample.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.ezetap.consumerpaymentsdk.activity.ServiceSDKActivity
import com.ezetap.consumerpaymentsdk.utils.Toaster
import com.ezetap.sample.BuildConfig
import com.ezetap.sample.BuildConfig.BUILD_TYPE
import com.ezetap.sample.R
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_upi.*
import kotlinx.android.synthetic.main.r_header.*
import org.json.JSONObject

//8310615397
@SuppressLint("LongLogTag")
class UpiActivity : AppCompatActivity() {
    var externalMerchantRef = ""
    val TAG = "com.ezetap.sample.activity.UpiActivity"
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

            if (etOrder.text.isNullOrBlank()) {
                Toaster.showLong("Please enter order id")
                return@setOnClickListener
            }

            val intent = Intent(this@UpiActivity, ServiceSDKActivity::class.java)
            val  jsonObject = JSONObject()
            jsonObject.put("amount",amount)
            jsonObject.put("userEmailAddress","atif.q@ezetap.com")
            Log.d("UpiActivity", "BuildType ${BuildConfig.BUILD_TYPE}")
            if(BuildConfig.BUILD_TYPE.equals("INLINE_UPI_TEST")){
                // INLINE_UPI_TEST
                jsonObject.put("merchantSimulatorToken","ewogICJraWQiIDogImI2YzU2MDc1LTU3ZTItNDI5Ni1hZmI4LWE4NTJkY2M1MzFlNSIsCiAgImFsZyIgOiAiUlMyNTYiLAogICJ0eXAiIDogIkpXVCIKfQ.ewogICJlbWFpbElkIiA6ICJ0ZXN0VXNlckB0ZXN0LmNvbSIsCiAgIm5hbWUiIDogIlRlc3RVc2VyIiwKICAicGhvbmVOdW1iZXIiIDogIjk4MzAwOTgzMDAiLAogICJtZXJjaGFudENvZGUiIDogIklOTElORV9VUElfVEVTVCIsCiAgImlzcyIgOiAiSU5MSU5FX1VQSV9URVNUIiwKICAiaWF0IiA6IDE2NTA5NTUzNjQsCiAgImV4cCIgOiAxNjc2ODc1MzY0Cn0.AEg5UFKmN52TQEuxhy9UoFGls44Gw8ROj8_SFV-3Zb5UKbaOeVBoUrkc4AvTnJEppDDaOhirV-XdqQT9bIkKGwnsAL2oJoIIT7eGBtv6eYWpBVJepd0t608HSKBA2aW_VT7PDLZMsOYqnTAFfTw3juxB2ULEeczzTcHRerOG_ldTD5owFkUn620dxoqBUcGhsv-q2HWww5S0Ul9sPMZGndT5al19b0f3AlfjguIYx58FGsfrQMn7TqOkHN08fchYN-G53pLYVz_msR0Md90yPfy3UHijXhWecgMB7Jh_rHJABTh7ZGH9A9xZUvaNst8l4qGY52L1EAHaxUQ_PDbD1w")
                jsonObject.put("merchantUUID","INLINE_UPI_TEST")
            }else if(BuildConfig.BUILD_TYPE.equals("INLINEUPIQA_9307")){
                // INLINEUPIQA_9307
                jsonObject.put("merchantSimulatorToken","ewogICJraWQiIDogImI2YzU2MDc1LTU3ZTItNDI5Ni1hZmI4LWE4NTJkY2M1MzFlNSIsCiAgImFsZyIgOiAiUlMyNTYiLAogICJ0eXAiIDogIkpXVCIKfQ.ewogICJlbWFpbElkIiA6ICJ0ZXN0VXNlckB0ZXN0LmNvbSIsCiAgIm5hbWUiIDogIlRlc3RVc2VyIiwKICAicGhvbmVOdW1iZXIiIDogIjk4MzAwOTgzMDAiLAogICJtZXJjaGFudENvZGUiIDogIklOTElORVVQSVFBXzkzMDciLAogICJpc3MiIDogIklOTElORVVQSVFBXzkzMDciLAogICJpYXQiIDogMTY1NTIwODg2MCwKICAiZXhwIiA6IDE2ODUyMDg4NjAKfQ.HJekRsVMHcqPAW1X3qMaYC918LpAqycMfb93P5cvcBicVQhFAB1X325rD2aDX0tBzaIJKHqqB8VRKoRAv_EhQ6q_6mrfymjIEpxXOR0TvkeICpPDi0BPgPZnRSV3Qh6aj4TFL3y-d98zzsNbx2tPvcMGukIi_9hHcj--lC3rJA8CcsGkvHGb2CQsd7fSIo-iIrK49X7mn0QPUhFxesuOltG2-hafBD1Dw_bMX0fOmNKfJnzkqkX1OUEMlk3aBV-JTqcmlWnxNPGBCPsj3aQnxObvG8feBGYNzJeNadkuqKN5Sx9lI-MkRgRU13UVUZNJLozKgDbrXlOA_t8Ekl9iHw")
                jsonObject.put("merchantUUID","INLINEUPIQA_9307")
            }else {
                // INLINE_UPI_TEST
                jsonObject.put("merchantSimulatorToken","ewogICJraWQiIDogImI2YzU2MDc1LTU3ZTItNDI5Ni1hZmI4LWE4NTJkY2M1MzFlNSIsCiAgImFsZyIgOiAiUlMyNTYiLAogICJ0eXAiIDogIkpXVCIKfQ.ewogICJlbWFpbElkIiA6ICJ0ZXN0VXNlckB0ZXN0LmNvbSIsCiAgIm5hbWUiIDogIlRlc3RVc2VyIiwKICAicGhvbmVOdW1iZXIiIDogIjk4MzAwOTgzMDAiLAogICJtZXJjaGFudENvZGUiIDogIklOTElORV9VUElfVEVTVCIsCiAgImlzcyIgOiAiSU5MSU5FX1VQSV9URVNUIiwKICAiaWF0IiA6IDE2NTA5NTUzNjQsCiAgImV4cCIgOiAxNjc2ODc1MzY0Cn0.AEg5UFKmN52TQEuxhy9UoFGls44Gw8ROj8_SFV-3Zb5UKbaOeVBoUrkc4AvTnJEppDDaOhirV-XdqQT9bIkKGwnsAL2oJoIIT7eGBtv6eYWpBVJepd0t608HSKBA2aW_VT7PDLZMsOYqnTAFfTw3juxB2ULEeczzTcHRerOG_ldTD5owFkUn620dxoqBUcGhsv-q2HWww5S0Ul9sPMZGndT5al19b0f3AlfjguIYx58FGsfrQMn7TqOkHN08fchYN-G53pLYVz_msR0Md90yPfy3UHijXhWecgMB7Jh_rHJABTh7ZGH9A9xZUvaNst8l4qGY52L1EAHaxUQ_PDbD1w")
                jsonObject.put("merchantUUID","INLINE_UPI_TEST")
            }

            if(!etExternalMerchantRef.text.isNullOrEmpty()) {
                jsonObject.put("externalMerchantRef", etExternalMerchantRef.text.toString())
            }else{
                jsonObject.put("externalMerchantRef", "")
            }

            jsonObject.put("phoneNumber", etPhoneNumber.text.toString())
            jsonObject.put("orderId", etOrder.text.toString())
            val data = jsonObject.toString()
            Log.d(TAG, "transactionRequest ${data}" )
            intent.putExtra("transactionRequest", data)
            startActivityForResult(intent,1001)
        }

        deRegistration.setOnClickListener {
            val intent = Intent(this@UpiActivity, ServiceSDKActivity::class.java)
            val  jsonObject = JSONObject()

            jsonObject.put("userEmailAddress","atif.q@ezetap.com")
            if(BuildConfig.BUILD_TYPE.equals("INLINE_UPI_TEST")){
                // INLINE_UPI_TEST
                jsonObject.put("merchantSimulatorToken","ewogICJraWQiIDogImI2YzU2MDc1LTU3ZTItNDI5Ni1hZmI4LWE4NTJkY2M1MzFlNSIsCiAgImFsZyIgOiAiUlMyNTYiLAogICJ0eXAiIDogIkpXVCIKfQ.ewogICJlbWFpbElkIiA6ICJ0ZXN0VXNlckB0ZXN0LmNvbSIsCiAgIm5hbWUiIDogIlRlc3RVc2VyIiwKICAicGhvbmVOdW1iZXIiIDogIjk4MzAwOTgzMDAiLAogICJtZXJjaGFudENvZGUiIDogIklOTElORV9VUElfVEVTVCIsCiAgImlzcyIgOiAiSU5MSU5FX1VQSV9URVNUIiwKICAiaWF0IiA6IDE2NTA5NTUzNjQsCiAgImV4cCIgOiAxNjc2ODc1MzY0Cn0.AEg5UFKmN52TQEuxhy9UoFGls44Gw8ROj8_SFV-3Zb5UKbaOeVBoUrkc4AvTnJEppDDaOhirV-XdqQT9bIkKGwnsAL2oJoIIT7eGBtv6eYWpBVJepd0t608HSKBA2aW_VT7PDLZMsOYqnTAFfTw3juxB2ULEeczzTcHRerOG_ldTD5owFkUn620dxoqBUcGhsv-q2HWww5S0Ul9sPMZGndT5al19b0f3AlfjguIYx58FGsfrQMn7TqOkHN08fchYN-G53pLYVz_msR0Md90yPfy3UHijXhWecgMB7Jh_rHJABTh7ZGH9A9xZUvaNst8l4qGY52L1EAHaxUQ_PDbD1w")
                jsonObject.put("merchantUUID","INLINE_UPI_TEST")

            }else if(BuildConfig.BUILD_TYPE.equals("INLINEUPIQA_9307")){
                // INLINEUPIQA_9307
                jsonObject.put("merchantSimulatorToken","ewogICJraWQiIDogImI2YzU2MDc1LTU3ZTItNDI5Ni1hZmI4LWE4NTJkY2M1MzFlNSIsCiAgImFsZyIgOiAiUlMyNTYiLAogICJ0eXAiIDogIkpXVCIKfQ.ewogICJlbWFpbElkIiA6ICJ0ZXN0VXNlckB0ZXN0LmNvbSIsCiAgIm5hbWUiIDogIlRlc3RVc2VyIiwKICAicGhvbmVOdW1iZXIiIDogIjk4MzAwOTgzMDAiLAogICJtZXJjaGFudENvZGUiIDogIklOTElORVVQSVFBXzkzMDciLAogICJpc3MiIDogIklOTElORVVQSVFBXzkzMDciLAogICJpYXQiIDogMTY1NTIwODg2MCwKICAiZXhwIiA6IDE2ODUyMDg4NjAKfQ.HJekRsVMHcqPAW1X3qMaYC918LpAqycMfb93P5cvcBicVQhFAB1X325rD2aDX0tBzaIJKHqqB8VRKoRAv_EhQ6q_6mrfymjIEpxXOR0TvkeICpPDi0BPgPZnRSV3Qh6aj4TFL3y-d98zzsNbx2tPvcMGukIi_9hHcj--lC3rJA8CcsGkvHGb2CQsd7fSIo-iIrK49X7mn0QPUhFxesuOltG2-hafBD1Dw_bMX0fOmNKfJnzkqkX1OUEMlk3aBV-JTqcmlWnxNPGBCPsj3aQnxObvG8feBGYNzJeNadkuqKN5Sx9lI-MkRgRU13UVUZNJLozKgDbrXlOA_t8Ekl9iHw")
                jsonObject.put("merchantUUID","INLINEUPIQA_9307")
            }else {
                // INLINE_UPI_TEST
                jsonObject.put("merchantSimulatorToken","ewogICJraWQiIDogImI2YzU2MDc1LTU3ZTItNDI5Ni1hZmI4LWE4NTJkY2M1MzFlNSIsCiAgImFsZyIgOiAiUlMyNTYiLAogICJ0eXAiIDogIkpXVCIKfQ.ewogICJlbWFpbElkIiA6ICJ0ZXN0VXNlckB0ZXN0LmNvbSIsCiAgIm5hbWUiIDogIlRlc3RVc2VyIiwKICAicGhvbmVOdW1iZXIiIDogIjk4MzAwOTgzMDAiLAogICJtZXJjaGFudENvZGUiIDogIklOTElORV9VUElfVEVTVCIsCiAgImlzcyIgOiAiSU5MSU5FX1VQSV9URVNUIiwKICAiaWF0IiA6IDE2NTA5NTUzNjQsCiAgImV4cCIgOiAxNjc2ODc1MzY0Cn0.AEg5UFKmN52TQEuxhy9UoFGls44Gw8ROj8_SFV-3Zb5UKbaOeVBoUrkc4AvTnJEppDDaOhirV-XdqQT9bIkKGwnsAL2oJoIIT7eGBtv6eYWpBVJepd0t608HSKBA2aW_VT7PDLZMsOYqnTAFfTw3juxB2ULEeczzTcHRerOG_ldTD5owFkUn620dxoqBUcGhsv-q2HWww5S0Ul9sPMZGndT5al19b0f3AlfjguIYx58FGsfrQMn7TqOkHN08fchYN-G53pLYVz_msR0Md90yPfy3UHijXhWecgMB7Jh_rHJABTh7ZGH9A9xZUvaNst8l4qGY52L1EAHaxUQ_PDbD1w")
                jsonObject.put("merchantUUID","INLINE_UPI_TEST")
            }
            jsonObject.put("phoneNumber", etPhoneNumber.text.toString())
            val data = jsonObject.toString()
            intent.putExtra("userSettingRequest", data)
            Log.d(TAG , "userSettingRequest ${data}" )
            startActivityForResult(intent,1002)
        }

        btOrderHistory.setOnClickListener {
            val intent = Intent(this@UpiActivity, ServiceSDKActivity::class.java)
            val  jsonObject = JSONObject()
            if (etPhoneNumber.text.isNullOrBlank()) {
                Toaster.showLong("Please enter mobile number")
                return@setOnClickListener
            }

            if (etOrder.text.isNullOrBlank()) {
                Toaster.showLong("Please enter order id")
                return@setOnClickListener
            }

            jsonObject.put("userEmailAddress","atif.q@ezetap.com")
            if(BuildConfig.BUILD_TYPE.equals("INLINE_UPI_TEST")){
                // INLINE_UPI_TEST
                jsonObject.put("merchantSimulatorToken","ewogICJraWQiIDogImI2YzU2MDc1LTU3ZTItNDI5Ni1hZmI4LWE4NTJkY2M1MzFlNSIsCiAgImFsZyIgOiAiUlMyNTYiLAogICJ0eXAiIDogIkpXVCIKfQ.ewogICJlbWFpbElkIiA6ICJ0ZXN0VXNlckB0ZXN0LmNvbSIsCiAgIm5hbWUiIDogIlRlc3RVc2VyIiwKICAicGhvbmVOdW1iZXIiIDogIjk4MzAwOTgzMDAiLAogICJtZXJjaGFudENvZGUiIDogIklOTElORV9VUElfVEVTVCIsCiAgImlzcyIgOiAiSU5MSU5FX1VQSV9URVNUIiwKICAiaWF0IiA6IDE2NTA5NTUzNjQsCiAgImV4cCIgOiAxNjc2ODc1MzY0Cn0.AEg5UFKmN52TQEuxhy9UoFGls44Gw8ROj8_SFV-3Zb5UKbaOeVBoUrkc4AvTnJEppDDaOhirV-XdqQT9bIkKGwnsAL2oJoIIT7eGBtv6eYWpBVJepd0t608HSKBA2aW_VT7PDLZMsOYqnTAFfTw3juxB2ULEeczzTcHRerOG_ldTD5owFkUn620dxoqBUcGhsv-q2HWww5S0Ul9sPMZGndT5al19b0f3AlfjguIYx58FGsfrQMn7TqOkHN08fchYN-G53pLYVz_msR0Md90yPfy3UHijXhWecgMB7Jh_rHJABTh7ZGH9A9xZUvaNst8l4qGY52L1EAHaxUQ_PDbD1w")
                jsonObject.put("merchantUUID","INLINE_UPI_TEST")

            }else if(BuildConfig.BUILD_TYPE.equals("INLINEUPIQA_9307")){
                // INLINEUPIQA_9307
                jsonObject.put("merchantSimulatorToken","ewogICJraWQiIDogImI2YzU2MDc1LTU3ZTItNDI5Ni1hZmI4LWE4NTJkY2M1MzFlNSIsCiAgImFsZyIgOiAiUlMyNTYiLAogICJ0eXAiIDogIkpXVCIKfQ.ewogICJlbWFpbElkIiA6ICJ0ZXN0VXNlckB0ZXN0LmNvbSIsCiAgIm5hbWUiIDogIlRlc3RVc2VyIiwKICAicGhvbmVOdW1iZXIiIDogIjk4MzAwOTgzMDAiLAogICJtZXJjaGFudENvZGUiIDogIklOTElORVVQSVFBXzkzMDciLAogICJpc3MiIDogIklOTElORVVQSVFBXzkzMDciLAogICJpYXQiIDogMTY1NTIwODg2MCwKICAiZXhwIiA6IDE2ODUyMDg4NjAKfQ.HJekRsVMHcqPAW1X3qMaYC918LpAqycMfb93P5cvcBicVQhFAB1X325rD2aDX0tBzaIJKHqqB8VRKoRAv_EhQ6q_6mrfymjIEpxXOR0TvkeICpPDi0BPgPZnRSV3Qh6aj4TFL3y-d98zzsNbx2tPvcMGukIi_9hHcj--lC3rJA8CcsGkvHGb2CQsd7fSIo-iIrK49X7mn0QPUhFxesuOltG2-hafBD1Dw_bMX0fOmNKfJnzkqkX1OUEMlk3aBV-JTqcmlWnxNPGBCPsj3aQnxObvG8feBGYNzJeNadkuqKN5Sx9lI-MkRgRU13UVUZNJLozKgDbrXlOA_t8Ekl9iHw")
                jsonObject.put("merchantUUID","INLINEUPIQA_9307")
            }else {
                // INLINE_UPI_TEST
                jsonObject.put("merchantSimulatorToken","ewogICJraWQiIDogImI2YzU2MDc1LTU3ZTItNDI5Ni1hZmI4LWE4NTJkY2M1MzFlNSIsCiAgImFsZyIgOiAiUlMyNTYiLAogICJ0eXAiIDogIkpXVCIKfQ.ewogICJlbWFpbElkIiA6ICJ0ZXN0VXNlckB0ZXN0LmNvbSIsCiAgIm5hbWUiIDogIlRlc3RVc2VyIiwKICAicGhvbmVOdW1iZXIiIDogIjk4MzAwOTgzMDAiLAogICJtZXJjaGFudENvZGUiIDogIklOTElORV9VUElfVEVTVCIsCiAgImlzcyIgOiAiSU5MSU5FX1VQSV9URVNUIiwKICAiaWF0IiA6IDE2NTA5NTUzNjQsCiAgImV4cCIgOiAxNjc2ODc1MzY0Cn0.AEg5UFKmN52TQEuxhy9UoFGls44Gw8ROj8_SFV-3Zb5UKbaOeVBoUrkc4AvTnJEppDDaOhirV-XdqQT9bIkKGwnsAL2oJoIIT7eGBtv6eYWpBVJepd0t608HSKBA2aW_VT7PDLZMsOYqnTAFfTw3juxB2ULEeczzTcHRerOG_ldTD5owFkUn620dxoqBUcGhsv-q2HWww5S0Ul9sPMZGndT5al19b0f3AlfjguIYx58FGsfrQMn7TqOkHN08fchYN-G53pLYVz_msR0Md90yPfy3UHijXhWecgMB7Jh_rHJABTh7ZGH9A9xZUvaNst8l4qGY52L1EAHaxUQ_PDbD1w")
                jsonObject.put("merchantUUID","INLINE_UPI_TEST")
            }
            jsonObject.put("phoneNumber", etPhoneNumber.text.toString())
            jsonObject.put("orderId", etOrder.text.toString())
            if(!etExternalMerchantRef.text.isNullOrEmpty()) {
                jsonObject.put("externalMerchantRef", etExternalMerchantRef.text.toString())
            }else{
                jsonObject.put("externalMerchantRef", "")
            }
            val data = jsonObject.toString()
            intent.putExtra("transactionDetailRequest", data)
            Log.d(TAG , "transactionDetailRequest ${data}" )
            startActivityForResult(intent,1003)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "onActivityResult ${data} requestCode $requestCode resultCode $resultCode" )
        if(requestCode== 1001 ){
            Log.d(TAG , "onActivityResult ${data?.extras}" )
            if(data!=null){
                Log.d(TAG, "dat : ${data.getStringExtra("responseData")}")
                val intentData  = JSONObject(data.getStringExtra("responseData").toString())
                Toast.makeText(this, intentData.getString("result") , Toast.LENGTH_LONG).show()
            }

        }else if(requestCode== 1002){
            Log.d(TAG , "onActivityResult ${data?.extras}" )
            if(data!=null){
                Log.d(TAG, "dat : ${data.getStringExtra("responseData")}")
                val intentData  = JSONObject(data.getStringExtra("responseData").toString())
                Toast.makeText(this, intentData.getString("result") , Toast.LENGTH_LONG).show()
            }

        }else if(requestCode== 1003){
            Log.d(TAG , "onActivityResult ${data?.extras}" )
            if(data!=null){
                Log.d(TAG, "dat : ${data.getStringExtra("responseData")}")
                val intentData  = JSONObject(data.getStringExtra("responseData").toString())
                Toast.makeText(this, intentData.getString("result") , Toast.LENGTH_LONG).show()
            }
        }

    }

    fun randomNumber():Int{
        return  (0..10000).random()
    }
}