package com.rnnativemodule

import android.content.Intent
import android.util.Log
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class NativeModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {
    override fun getName(): String {
        return "NativeModule"
    }

    @ReactMethod
    fun showView(promise: Promise) {
        val intent = Intent(reactApplicationContext, NativeModuleActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        reactApplicationContext.startActivity(intent)
        promise.resolve(true)
    }

    @ReactMethod
    fun showViewNavigateTo(text: String? = "", promise: Promise) {
        val intent = Intent(reactApplicationContext, NativeModuleActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        Log.d("put screenId", text ?: "")
        intent.putExtra("screenId", text)
        reactApplicationContext.startActivity(intent)
        promise.resolve(true)
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    fun testNativePerf(): String {
        val startTime = System.currentTimeMillis()
        repeat(1000000) {
            listOf(1, 2, 3, 4, 5).sum()
        }
        val endTime = System.currentTimeMillis()
        val counter = endTime - startTime
        Log.d("Time taken", "${endTime - startTime} ms")

        return "Time taken ${endTime - startTime} ms"
    }
}