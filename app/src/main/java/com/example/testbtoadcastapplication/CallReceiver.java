package com.example.testbtoadcastapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.testbtoadcastapplication.Database.BroadCastRepository;
import com.example.testbtoadcastapplication.Model.BroadcastInfo;

import java.util.Date;

public class CallReceiver extends BroadcastReceiver {
    private final BroadcastInfo mBroadcastInfo=new BroadcastInfo();
    @Override
    public void onReceive(Context context, Intent intent) {
        BroadCastRepository repository = BroadCastRepository.getInstance(context);
        Toast.makeText(context,"this is test with "+intent.getAction(),Toast.LENGTH_LONG).show();
        mBroadcastInfo.setEvent("IN");
        mBroadcastInfo.setTimestamp(new Date().getTime());
        mBroadcastInfo.setType("CALL");

        repository.insert(mBroadcastInfo);
    }
}
