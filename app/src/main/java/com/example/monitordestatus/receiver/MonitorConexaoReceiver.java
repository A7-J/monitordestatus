package com.example.monitordestatus.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.monitordestatus.util.Constants;

public class MonitorConexaoReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        boolean conectado =
                networkInfo != null && networkInfo.isConnectedOrConnecting();

        String mensagem = conectado ?
                "Conectado à internet" :
                "Sem conexão com a internet";

        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();

        Intent localIntent =
                new Intent(Constants.ACTION_CONEXAO_STATUS);
        localIntent.putExtra(Constants.EXTRA_MENSAGEM, mensagem);

        LocalBroadcastManager
                .getInstance(context)
                .sendBroadcast(localIntent);
    }
}
