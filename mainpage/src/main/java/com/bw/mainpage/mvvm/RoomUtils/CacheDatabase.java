package com.bw.mainpage.mvvm.RoomUtils;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @ClassName CacheDatabase
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/19 15:16
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */


@Database(entities={CacheBean.class},version=2,exportSchema=false)
public abstract class CacheDatabase extends RoomDatabase {

    private static volatile CacheDatabase instance;

    public static synchronized CacheDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static CacheDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                CacheDatabase.class,
                "cache.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public abstract CacheDao getCacheDao();



}
