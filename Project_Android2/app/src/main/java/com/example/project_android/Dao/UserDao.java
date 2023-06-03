package com.example.project_android.Dao;

import androidx.room.Dao;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.project_android.Entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Query("Select * from users")
    List<User> getAllUser();

    @Query("SELECT * FROM users WHERE username = :username")
    User getUserByUsername(String username);
//    @Query("SELECT EXISTS(SELECT * FROM users WHERE username = :username AND password = :password)")
//    boolean login(String username, String password);
//
//
//    @Query("SELECT EXISTS(SELECT * FROM users WHERE username = :username )")
//    boolean signup(String username);
}