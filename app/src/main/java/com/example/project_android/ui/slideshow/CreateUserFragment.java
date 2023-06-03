package com.example.project_android.ui.slideshow;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.project_android.App_Database.AppDatabase;
import com.example.project_android.Dao.UserDao;
import com.example.project_android.Entity.User;
import com.example.project_android.R;

public class CreateUserFragment extends Fragment {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button createUserButton;
    private UserDao userDao;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_user, container, false);

        usernameEditText = view.findViewById(R.id.usernameEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        createUserButton = view.findViewById(R.id.createUserButton);

        AppDatabase appDatabase = Room.databaseBuilder(requireContext(), AppDatabase.class, "my-database").allowMainThreadQueries().build();
        userDao = appDatabase.userDao();

        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                User existingUser = userDao.getUserByUsername(username);
                if (existingUser != null) {
                    // User exists, prompt for a new username
                    Toast.makeText(requireContext(), "Username is already taken. Please choose a different username.", Toast.LENGTH_SHORT).show();
                    return;
                }

                User newUser = new User(username, password);
                User user1= new User("moiz","hussain");
                userDao.insert(newUser);

                Toast.makeText(requireContext(), "User created successfully", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}