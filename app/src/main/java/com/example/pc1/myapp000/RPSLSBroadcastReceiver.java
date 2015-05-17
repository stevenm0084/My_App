package com.example.pc1.myapp000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;
import android.widget.Toast;

//import java.nio.channels.Channel;
import android.net.wifi.p2p.WifiP2pManager.Channel;

/**
 * Created by PC1 on 17-May-15.
 */
public class RPSLSBroadcastReceiver extends BroadcastReceiver {

    private WifiP2pManager mManager;
    private Channel mChannel;
    private Play2PlayerGameActivity mActivity;


    public RPSLSBroadcastReceiver(WifiP2pManager manager, Channel channel, Play2PlayerGameActivity activity) {
        super();
        this.mManager = manager;
        this.mChannel = channel;
        this.mActivity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            // Check to see if Wi-Fi is enabled and notify appropriate activity
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                //Toast.makeText(mActivity, "WIFI IS ENABLED", Toast.LENGTH_LONG).show();
                // mActivity.setIsWifiP2pEnabled(true);

                Log.i("BROADCASTRECEIVER", "WIFI IS ENABLED");
            } else {
                Log.i("BROADCASTRECEIVER", "WIFI IS NOT ENABLED");
            }


        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
            // Call WifiP2pManager.requestPeers() to get a list of current peers
            if (mManager != null) {
                //  mManager.requestPeers(mChannel, peerListListener);
            }
            //Log.d(WiFiDirectActivity.TAG, "P2P peers changed");


        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
            // Respond to new connection or disconnections
        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
            // Respond to this device's wifi state changing
        }
    }


}
