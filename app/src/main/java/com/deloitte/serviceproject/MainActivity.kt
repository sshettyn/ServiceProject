package com.deloitte.serviceproject

import android.app.Notification
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

  lateinit var airplaneModeChangeReceiver: AirplaneModeChangeReceiver

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val start = findViewById<Button>(R.id.start)
    val stop = findViewById<Button>(R.id.stop)
    val sendData = findViewById<Button>(R.id.sendDataButton)
    val info = findViewById<TextView>(R.id.infoText)
    val sendDataInput = findViewById<EditText>(R.id.sendData)

    airplaneModeChangeReceiver = AirplaneModeChangeReceiver()

    IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
      registerReceiver(airplaneModeChangeReceiver,it)
    }
    /*start.setOnClickListener {
        Intent(this,MyIntentService::class.java).also {
          startService(it)
          info.text = "Service running"
        }
    }

    stop.setOnClickListener {
        MyIntentService.stopService()
      info.text = "Service stopped"

    }*/

    start.setOnClickListener {
      Intent(this,MyService::class.java).also {
        startService(it)
        info.text = "Service running"
      }
    }

    stop.setOnClickListener {
      Intent(this,MyService::class.java).also {
        stopService(it)
        info.text = "Service stopped"
      }

    }

    sendData.setOnClickListener {
      Intent(this,MyService::class.java).also {
        val data = sendDataInput.text.toString()
        it.putExtra("DATA",data)
        startService(it)
      }
    }
  }

  override fun onStop() {
    super.onStop()
    unregisterReceiver(airplaneModeChangeReceiver)
  }
}