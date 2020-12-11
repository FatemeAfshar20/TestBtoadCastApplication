package com.example.testbtoadcastapplication.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.testbtoadcastapplication.Model.BroadcastInfo;

@Database(entities = {BroadcastInfo.class},version = 1)
public abstract class BroadcastDatabase extends RoomDatabase {
    public abstract BroadCastDao getBroadcastDao();
}
