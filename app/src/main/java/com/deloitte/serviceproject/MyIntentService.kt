package com.deloitte.serviceproject

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

private const val TAG = "MyIntentService"

class MyIntentService : IntentService("MyIntentService") {
  companion object{
    private lateinit var myIntentService: MyIntentService
    var running = false

    fun stopService(){
      Log.v(TAG,"SERVICE STOPPED")
      running = false
      myIntentService.stopSelf()
    }
  }

  init {
    myIntentService  = this
  }

  override fun onHandleIntent(intent: Intent?) {
    running = true
    Log.v(TAG,"Intent service is runnning")
  }


}