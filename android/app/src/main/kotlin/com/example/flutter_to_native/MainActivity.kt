package com.example.flutter_to_native

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity : FlutterActivity() {
    private val TEST_CHANNEL = "flutter.native/helper"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor
                .binaryMessenger, TEST_CHANNEL
        ).setMethodCallHandler { call, result ->
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
