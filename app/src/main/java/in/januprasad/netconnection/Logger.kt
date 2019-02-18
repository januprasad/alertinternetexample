package `in`.januprasad.netconnection

import android.util.Log

/**
 * Created by januprasad on 18,February,2019
 */

object Logger {
    val TAG = "Logger"
    fun logv(msg: String) {
        Log.v(TAG, msg)
    }
}