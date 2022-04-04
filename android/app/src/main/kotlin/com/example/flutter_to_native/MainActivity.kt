package com.example.flutter_to_native

import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "flutter.native/helper"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MethodChannel(
            flutterEngine?.dartExecutor
                ?.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "helloFromNativeCode") {
                val greetings: String = helloFromNativeCode()
                result.success(greetings)
            }
        }
    }

    fun helloFromNativeCode(): String {
        return "Hello From Native Code"
    }
}
