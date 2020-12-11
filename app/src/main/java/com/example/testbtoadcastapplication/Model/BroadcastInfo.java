package com.example.testbtoadcastapplication.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BroadcastInfoTable")
public class BroadcastInfo {

    @PrimaryKey(autoGenerate = true)
    private long mId;
    @ColumnInfo(name = "event log")
    private String mEvent;
    @ColumnInfo(name = "time stamp")
    private long mTimestamp;
    @ColumnInfo(name = "type")
    private String mType;

    public BroadcastInfo() {
        mId=(int )(Math.random() * 200 + 1);
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getEvent() {
        return mEvent;
    }

    public void setEvent(String event) {
        mEvent = event;
    }

    public long getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(long timestamp) {
        mTimestamp = timestamp;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}
