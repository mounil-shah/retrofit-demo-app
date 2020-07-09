package com.example.retrofitdemoapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//public class UserRepositoryRetrofit implements UsersRepositoryInterface {
public class UserRepositoryRetrofit {
    public UserService userService;
    public UserRepositoryRetrofit() {
        userService = ApiClient.INSTANCE.createUserService();
        getUsers();
    }
    final MutableLiveData<List<UserResponse>> userListMutableLiveData = new MutableLiveData<>();
    final MutableLiveData<String> userListErrorMutableLiveData = new MutableLiveData<>();

    public LiveData<List<UserResponse>> getUserListLiveData() {
        return userListMutableLiveData;
    }

    public LiveData<String> getUserListErrorLiveData() {
        return userListErrorMutableLiveData;
    }

    private void getUsers() {
        Call<List<UserResponse>> userList = userService.getAllUsers();
        userList.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                if (response.isSuccessful()) {
                    userListMutableLiveData.postValue(response.body());
                }
                else {
                    try {
                        userListErrorMutableLiveData.postValue(response.errorBody().string());
                    } catch (IOException e) {
                        userListErrorMutableLiveData.postValue(e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                userListErrorMutableLiveData.postValue(t.toString());
            }
        });
    }

}
