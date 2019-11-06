package com.example.fluttertoanexistingnativeapp

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint
import io.flutter.facade.Flutter
import io.flutter.view.FlutterMain


class MyApplication : Application() {
    lateinit var flutterEngine: FlutterEngine
    override fun onCreate() {
        super.onCreate()
        FlutterMain.startInitialization(applicationContext)
        FlutterMain.ensureInitializationComplete(applicationContext, arrayOf<String>())
        flutterEngine =
            FlutterEngine(this)
        val entrypoint = DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(),"main")
        flutterEngine.dartExecutor.executeDartEntrypoint(entrypoint)
    }

}