package com.haohao.rememberearn

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import java.lang.ref.WeakReference

var application: WeakReference<RememberEarnApplication> = WeakReference(null)

@HiltAndroidApp
class RememberEarnApplication : Application() {
    private val TAG = "RememberEarnApplication"


    override fun onCreate() {
        super.onCreate()
        application = WeakReference(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
}
