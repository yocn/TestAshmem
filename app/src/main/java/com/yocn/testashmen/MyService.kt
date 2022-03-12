package com.yocn.testashmen

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return MemFileBinder()
    }

     class MemFileBinder : IMemFileAIDLInterface.Stub() {
         override fun getHost(): String {
             return "new AIDL"
         }
     }

}