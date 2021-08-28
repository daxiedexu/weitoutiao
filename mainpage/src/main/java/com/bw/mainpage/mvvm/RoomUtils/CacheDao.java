package com.bw.mainpage.mvvm.RoomUtils;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * @ClassName CacheDao
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/19 15:01
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */

@Dao
public interface CacheDao {
    /**
     * 查询所有
     * @return
     */
    @Query("SELECT * FROM CacheBean")
    List<CacheBean> getAll();


    @Query("SELECT * FROM CacheBean Where rid IN (:userIds)")
    List<CacheBean> loadAllByIds(int[] userIds);

    @Insert
    void insertAll(CacheBean... users);

    @Delete
    void delete(CacheBean user);


    @Query("DELETE FROM CacheBean")
    void deleteAll();


}
