package com.example.project_android.App_Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project_android.Dao.UserDao;
import com.example.project_android.Entity.User;

@Database(entities = {User.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

}
