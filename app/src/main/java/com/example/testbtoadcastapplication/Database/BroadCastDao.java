package com.example.testbtoadcastapplication.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testbtoadcastapplication.Model.BroadcastInfo;

import java.util.List;

@Dao
public interface BroadCastDao {
    @Query("SELECT * FROM BroadcastInfoTable")
    List<BroadcastInfo> getList();
    @Query("SELECT * FROM broadcastinfotable WHERE mId=:id")
    BroadcastInfo get(long id);
    @Insert
    void insert(BroadcastInfo broadcastInfo);
    @Delete
    void delete(BroadcastInfo broadcastInfo);
    @Update
    void update(BroadcastInfo broadcastInfo);
}
