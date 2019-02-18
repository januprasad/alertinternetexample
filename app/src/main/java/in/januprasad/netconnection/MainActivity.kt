package `in`.januprasad.netconnection

import `in`.januprasad.netconnection.Logger.logv
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tapadoo.alerter.Alerter

/**
 * Created by januprasad on 18,February,2019
 */

class MainActivity : AppCompatActivity() {

    private var wasOffline = false
    private var isOffline = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNetwork()
    }


    private val networkConnectionListener = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            if (NetworkUtil.connectionStatus == ConnectionStatus.ONLINE) {
                if (wasOffline) {

                    Alerter.create(this@MainActivity)
                            .setTitle("Here we go!")
                            .setText("Device is back online")
                            .setDuration(4_000)
                            .setIcon(R.drawable.success)
                            .enableSwipeToDismiss()
                            .setBackgroundDrawable(GradientGenerator.successGradient)
                            .show()

//                    searchLayout.isErrorEnabled = false
                }
                wasOffline = false
                isOffline = false
            } else {
                Alerter.create(this@MainActivity)
                        .setTitle("Device offline")
                        .setText("You need an active internet connection to use this app")
                        .setDuration(4_000)
                        .setIcon(R.drawable.error)
                        .enableSwipeToDismiss()
                        .setBackgroundDrawable(GradientGenerator.errorGradient)
                        .setOnClickListener(
                                View.OnClickListener { startActivityForResult(Intent(Settings.ACTION_WIFI_SETTINGS), 0) })
                        .show()

                wasOffline = true
                isOffline = true
            }
        }
    }

    private fun initNetwork() = registerReceiver(networkConnectionListener, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))

    private fun unregisterReceivers() = try {
        unregisterReceiver(networkConnectionListener)
    } catch (notRegistered: RuntimeException) {
        logv(notRegistered.localizedMessage)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceivers()
    }


}
