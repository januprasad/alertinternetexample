package `in`.januprasad.netconnection

import android.app.Application

/**
 * Created by januprasad on 18,February,2019
 */

class App : Application() {
    companion object {
        var instance by Delegates.singleValue<Application>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}