package com.sultanov.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            MyService.LOADED -> {
                val percent = intent.getIntExtra("percent", 0)
                Toast.makeText(context, "Loaded $percent", Toast.LENGTH_SHORT).show()
            }
            ACTION_CLICKED -> {
                val count = intent.getIntExtra(EXTRA_COUNT, 0)
                Toast.makeText(context, "Clicked $count", Toast.LENGTH_SHORT).show()
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                Toast.makeText(context, "Airplane mode changed", Toast.LENGTH_SHORT).show()
            }
            Intent.ACTION_BATTERY_LOW -> {
                val turnedOn = intent.getBooleanExtra("state", false)
                Toast.makeText(
                    context,
                    "action battery low $turnedOn",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {

        const val ACTION_CLICKED = "clicked"
        const val EXTRA_COUNT = "count"
    }
}