package com.yocn.client

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yocn.testashmen.IMemFileAIDLInterface

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent()
        intent.action = "com.yocn.testashmen"
        intent.`package` = "com.yocn.testashmen"

//        intent.component = ComponentName("com.yocn.testashmen",
//            "com.yocn.testashmen.MyService")

        bindService(intent, object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.d("yocnyocn", "onServiceConnected ComponentName::" + name)
                val memFile = IMemFileAIDLInterface.Stub.asInterface(service)
                Log.d("yocnyocn", "host::" + memFile.host)
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                Log.d("yocnyocn", "onServiceDisconnected ComponentName::" + name)

            }
        }, BIND_AUTO_CREATE)

    }
}