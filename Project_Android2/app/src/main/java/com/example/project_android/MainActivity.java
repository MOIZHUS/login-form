package com.example.project_android;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project_android.App_Database.AppDatabase;
import com.example.project_android.Dao.UserDao;
import com.example.project_android.Entity.User;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private CheckBox rememberMeCheckbox;
    private Button loginButton;

    private AppDatabase appDatabase;
    private UserDao userDao;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        rememberMeCheckbox = findViewById(R.id.rememberMeCheckbox);
        loginButton = findViewById(R.id.b1);

        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "my-database").allowMainThreadQueries().build();
        userDao = appDatabase.userDao();
        User user1= new User("moiz","hussain");
        userDao.insert(user1);
        sharedPreferences = getSharedPreferences("login_pref", MODE_PRIVATE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                User existingUser = userDao.getUserByUsername(username);
                if (existingUser != null) {
                    // User exists
                    Log.d("MainActivity", "User exists: " + existingUser.getUsername());
                    Log.d("MainActivity", "User password: " + existingUser.getPassword());

                    if (existingUser.getPassword().equals(password)) {
                        // Password is correct
                        Log.d("MainActivity", "Password is correct");
                        performLogin(rememberMeCheckbox.isChecked());
                    } else {
                        // Incorrect password
                        Log.d("MainActivity", "Incorrect password");
                        Toast.makeText(MainActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // User does not exist
                    Log.d("MainActivity", "User does not exist");
                    Toast.makeText(MainActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
                }

//                User existingUser = userDao.getUserByUsername(username);
//                if (existingUser != null) {
//                    // User already exists, check the password
//                    if (existingUser.getPassword().equals(password)) {
//                        performLogin(rememberMeCheckbox.isChecked());
//                    } else {
//                        Toast.makeText(MainActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(MainActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
//
//
//                    // User does not exist, create a new user and perform login
//                    User newUser = new User(username, password);
//                    userDao.insert(newUser);
//                    performLogin(rememberMeCheckbox.isChecked());
//                }
            }
        });

        boolean rememberMe = sharedPreferences.getBoolean("remember_me", false);
        rememberMeCheckbox.setChecked(rememberMe);

        if (rememberMe) {
            navigateToNavigationDrawer();
        }
    }

    private void performLogin(boolean rememberMe) {
        if (rememberMe) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("remember_me", true);
            editor.apply();
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("remember_me");
            editor.apply();
        }

        navigateToNavigationDrawer();
    }

    private void navigateToNavigationDrawer() {
        Intent intent = new Intent(MainActivity.this, NavigationDrawerActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); // Update this line
        startActivity(intent);
        finish();
    }
}


