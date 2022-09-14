package com.deloitte.serviceproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver : BroadcastReceiver() {

  override fun onReceive(context: Context?, intent: Intent?) {
    val airplaneModeChanged = intent?.getBooleanExtra("state",false) ?: false

    if(airplaneModeChanged){
      Toast.makeText(context,"Airplane mode enabled",Toast.LENGTH_LONG).show()
    }else{
      Toast.makeText(context,"Airplane mode disabled",Toast.LENGTH_LONG).show()
    }
  }

}