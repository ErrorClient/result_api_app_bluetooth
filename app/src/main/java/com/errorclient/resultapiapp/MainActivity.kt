package com.errorclient.resultapiapp

import android.bluetooth.BluetoothAdapter
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit


class MainActivity : AppCompatActivity() {

    private lateinit var bluetoothReceiver: BluetoothStateReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add<FirstFragment>(R.id.fragment_container_view)
            }
        }

        /**
         * Подписываемся, когда создана стартовая активити
         */
        bluetoothReceiver = BluetoothStateReceiver()
        val filter = IntentFilter()
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED)
        registerReceiver(bluetoothReceiver, filter)
    }

    /**
     * Отписываемся, когда активити уничтожается
     */
    override fun onDestroy() {
        unregisterReceiver(bluetoothReceiver)
        super.onDestroy()
    }
}