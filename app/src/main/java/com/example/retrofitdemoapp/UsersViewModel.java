package com.example.retrofitdemoapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;


public class UsersViewModel extends ViewModel {

    private UserRepositoryRetrofit userRepository;

    public UsersViewModel() {
        userRepository = new UserRepositoryRetrofit();
    }

    public LiveData<List<UserResponse>> getUserResponsesLiveDate() {
        return userRepository.getUserListLiveData();
    }

    public LiveData<String> getUserResponseErrorLiveData() {
        return userRepository.getUserListErrorLiveData();
    }

}
