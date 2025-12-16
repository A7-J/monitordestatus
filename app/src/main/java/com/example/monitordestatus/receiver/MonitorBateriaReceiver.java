package com.example.monitordestatus.receiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.monitordestatus.R;

public class MonitorBateriaReceiver extends BroadcastReceiver {

    private static final String CHANNEL_ID = "canal_bateria_aviso";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_BATTERY_LOW.equals(intent.getAction())) {

            criarCanal(context);

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(context, CHANNEL_ID)
                            .setSmallIcon(R.drawable.ic_battery_warning)
                            .setContentTitle(context.getString(R.string.battery_warning_title))
                            .setContentText(context.getString(R.string.battery_warning_message))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setAutoCancel(true);

            NotificationManager manager =
                    (NotificationManager) context
                            .getSystemService(Context.NOTIFICATION_SERVICE);

            manager.notify(1, builder.build());
        }
    }

    private void criarCanal(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel =
                    new NotificationChannel(
                            CHANNEL_ID,
                            context.getString(R.string.battery_channel_name),
                            NotificationManager.IMPORTANCE_HIGH
                    );

            NotificationManager manager =
                    context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
}
