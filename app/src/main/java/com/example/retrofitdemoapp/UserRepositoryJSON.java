package com.example.retrofitdemoapp;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepositoryJSON implements UsersRepositoryInterface {
    String JSONString = "[\n" +
            "    {\n" +
            "        \"id\": 59,\n" +
            "        \"url\": \"http://api.larntech.net/users/59/\",\n" +
            "        \"username\": \"chan\",\n" +
            "        \"first_name\": \"\",\n" +
            "        \"last_name\": \"\",\n" +
            "        \"email\": \"\",\n" +
            "        \"is_active\": true,\n" +
            "        \"date_joined\": \"2020-06-21 05:18:39\",\n" +
            "        \"last_login\": null\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": 58,\n" +
            "        \"url\": \"http://api.larntech.net/users/58/\",\n" +
            "        \"username\": \"kannan\",\n" +
            "        \"first_name\": \"\",\n" +
            "        \"last_name\": \"\",\n" +
            "        \"email\": \"\",\n" +
            "        \"is_active\": true,\n" +
            "        \"date_joined\": \"2020-06-20 04:55:08\",\n" +
            "        \"last_login\": null\n" +
            "    }]";

    @Override
    public LiveData<List<UserResponse>> getUsers() {
        return null;
    }
}
