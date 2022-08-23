package com.errorclient.resultapiapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Если приложение запущено и изменили состояние Bluetooth,
 * то сообщаем об этом пользователю
 */
class BluetoothStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {

        Toast.makeText(context, "Bluetooth_STATE_CHANGED", Toast.LENGTH_LONG).show()
    }
}