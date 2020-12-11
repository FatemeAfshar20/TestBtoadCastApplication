package com.example.testbtoadcastapplication.Model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.testbtoadcastapplication.Database.BroadCastRepository;

import java.util.Date;

public class WiFiReceiver extends BroadcastReceiver {
    private final BroadcastInfo mBroadcastInfo=new BroadcastInfo();

    @Override
    public void onReceive(Context context, Intent intent) {
        BroadCastRepository repository = BroadCastRepository.getInstance(context);
        Toast.makeText(context,"this is test with "+intent.getAction(),Toast.LENGTH_LONG).show();
        mBroadcastInfo.setEvent("");
        mBroadcastInfo.setTimestamp(new Date().getTime());
        mBroadcastInfo.setType("WIFI");

        repository.insert(mBroadcastInfo);
    }
}
