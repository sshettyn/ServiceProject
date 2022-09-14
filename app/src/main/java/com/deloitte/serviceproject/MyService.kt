package com.deloitte.serviceproject

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

  private  val TAG = "MyService"

  init {
    Log.v(TAG,"service is started")
  }

  override fun onBind(intent: Intent): IBinder {
    TODO("Return the communication channel to the service.")
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    val data = intent?.getStringExtra("DATA")
    data?.let {
      Log.v(TAG,it)
    }
    return super.onStartCommand(intent, flags, startId)

  }
}