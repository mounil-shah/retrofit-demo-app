package com.example.retrofitdemoapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public interface UsersRepositoryInterface {

    LiveData<List<UserResponse>> getUsers();

}
