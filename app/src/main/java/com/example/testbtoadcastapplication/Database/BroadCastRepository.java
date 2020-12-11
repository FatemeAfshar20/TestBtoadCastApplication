package com.example.testbtoadcastapplication.Database;

import android.content.Context;

import androidx.room.Room;

import com.example.testbtoadcastapplication.Model.BroadcastInfo;

import java.util.List;

public class BroadCastRepository {
    private static BroadCastRepository sInstance;
    private BroadCastDao mDao;
    private Context mContext;

    private BroadCastRepository(Context context) {
        mContext = context.getApplicationContext();
        BroadcastDatabase database = Room.
                databaseBuilder(mContext,
                        BroadcastDatabase.class,
                        "broadcastTest.db").
                allowMainThreadQueries().
                build();

        mDao = database.getBroadcastDao();
    }

    public static BroadCastRepository getInstance(Context context) {
        if (sInstance == null)
            sInstance = new BroadCastRepository(context);
        return sInstance;
    }

    public List<BroadcastInfo> getList() {
        return mDao.getList();
    }

    public BroadcastInfo get(long id) {
        return mDao.get(id);
    }

    public void insert(BroadcastInfo broadcastInfo) {
        mDao.insert(broadcastInfo);
    }

    public void delete(BroadcastInfo broadcastInfo) {
        mDao.delete(broadcastInfo);
    }

    public void update(BroadcastInfo broadcastInfo) {
        mDao.update(broadcastInfo);
    }
}
