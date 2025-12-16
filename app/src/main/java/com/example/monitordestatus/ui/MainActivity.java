package com.example.monitordestatus.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.monitordestatus.R;
import com.example.monitordestatus.receiver.MonitorConexaoReceiver;
import com.example.monitordestatus.util.Constants;

public class MainActivity extends AppCompatActivity {

    private TextView textLog;
    private MonitorConexaoReceiver conexaoReceiver;

    private final BroadcastReceiver localReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mensagem =
                    intent.getStringExtra(Constants.EXTRA_MENSAGEM);
            atualizarLog("Conectividade: " + mensagem);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_title));
        setSupportActionBar(toolbar);

        textLog = findViewById(R.id.textLog);
        conexaoReceiver = new MonitorConexaoReceiver();

        atualizarLog("Aplicativo iniciado.");
    }

    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(
                conexaoReceiver,
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        );

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(
                        localReceiver,
                        new IntentFilter(Constants.ACTION_CONEXAO_STATUS)
                );

        atualizarLog("Receivers registrados.");
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(conexaoReceiver);

        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(localReceiver);

        atualizarLog("Receivers desregistrados.");
    }

    public void atualizarLog(String mensagem) {
        textLog.append("\n" + mensagem);
    }
}
