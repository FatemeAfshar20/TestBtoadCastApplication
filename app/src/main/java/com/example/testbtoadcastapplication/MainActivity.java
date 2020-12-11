package com.example.testbtoadcastapplication;

import android.content.IntentFilter;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testbtoadcastapplication.Database.BroadCastRepository;
import com.example.testbtoadcastapplication.Model.BroadcastInfo;
import com.example.testbtoadcastapplication.Model.WiFiReceiver;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import static android.net.wifi.WifiManager.WIFI_STATE_CHANGED_ACTION;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private BroadCastRepository mRepository;

    private ReceiverAdapter mReceiverAdapter;

    private WiFiReceiver mWiFiReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWiFiReceiver=new WiFiReceiver();
        mRepository = BroadCastRepository.getInstance(this);
        findViews();

        setupAdapter();
    }

    private void setupAdapter() {
        mReceiverAdapter = new ReceiverAdapter(mRepository.getList());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mReceiverAdapter);

    }

    private void findViews() {
        mRecyclerView = findViewById(R.id.recycler_view);
    }

    public void updateUi() {
        if (mReceiverAdapter != null) {
            mReceiverAdapter.setBroadcastInfoList(mRepository.getList());
            mReceiverAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(WIFI_STATE_CHANGED_ACTION);
        registerReceiver(mWiFiReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(mWiFiReceiver);
    }

    public class ReceiverAdapter extends RecyclerView.Adapter<ReceiverAdapter.ReceiverHolder> {
        private List<BroadcastInfo> mBroadcastInfoList;

        public void setBroadcastInfoList(List<BroadcastInfo> broadcastInfoList) {
            mBroadcastInfoList = broadcastInfoList;
        }

        public ReceiverAdapter(List<BroadcastInfo> broadcastInfoList) {
            mBroadcastInfoList = broadcastInfoList;
        }

        @NonNull
        @Override
        public ReceiverHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).
                    inflate(R.layout.item_view,
                            parent,
                            false);

            return new ReceiverHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ReceiverHolder holder, int position) {
            holder.bind(mBroadcastInfoList.get(position));
        }

        @Override
        public int getItemCount() {
            return mBroadcastInfoList.size();
        }

        public class ReceiverHolder extends RecyclerView.ViewHolder {
            private MaterialTextView mType, mEvent, mTime;

            public ReceiverHolder(@NonNull View itemView) {
                super(itemView);

                findViews(itemView);
            }

            private void findViews(@NonNull View itemView) {
                mTime = itemView.findViewById(R.id.time_broadcast);
                mType = itemView.findViewById(R.id.type_broadcast);
                mEvent = itemView.findViewById(R.id.event_broadcast);
            }

            public void bind(BroadcastInfo broadcastInfo) {
                mType.setText(mType.getText() + broadcastInfo.getType());
                mTime.setText(mTime.getText().toString() + broadcastInfo.getTimestamp());
                mEvent.setText(mEvent.getText() + broadcastInfo.getEvent());
            }
        }
    }
}