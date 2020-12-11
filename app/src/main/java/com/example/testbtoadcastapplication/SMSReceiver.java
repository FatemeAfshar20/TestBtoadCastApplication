package com.example.testbtoadcastapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.example.testbtoadcastapplication.Database.BroadCastRepository;
import com.example.testbtoadcastapplication.Model.BroadcastInfo;

import java.util.Date;

public class SMSReceiver extends BroadcastReceiver {
    public static final String TAG="SMSReceiver";

    private final BroadcastInfo mBroadcastInfo=new BroadcastInfo();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"SMS BroadcastReceiver");
        BroadCastRepository repository = BroadCastRepository.getInstance(context);
        Toast.makeText(context,"this is test with "+intent.getAction(),Toast.LENGTH_LONG).show();
            mBroadcastInfo.setEvent("IN");
            mBroadcastInfo.setTimestamp(new Date().getTime());
            mBroadcastInfo.setType("SMS");

            repository.insert(mBroadcastInfo);
    }
}