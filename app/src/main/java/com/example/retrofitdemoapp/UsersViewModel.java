package com.example.retrofitdemoapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;


public class UsersViewModel extends ViewModel {

    LiveData<List<UserResponse>> userResponsesLiveDate;

    public LiveData<List<UserResponse>> getUserResponsesLiveDate() {
        return userResponsesLiveDate;
    }

    UsersRepositoryInterface usersRepository;


    public UsersViewModel(){
        usersRepository = new UserRepositoryRetrofit();
        userResponsesLiveDate = usersRepository.getUsers();

    }



}
