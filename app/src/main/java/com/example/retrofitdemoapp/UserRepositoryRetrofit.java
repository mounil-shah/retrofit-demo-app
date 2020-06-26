package com.example.retrofitdemoapp;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepositoryRetrofit implements UsersRepositoryInterface {
    @Override
    public LiveData<List<UserResponse>> getUsers() {
        return userResponsesMutableLiveDate;
    }

    public UserRepositoryRetrofit() {

        getAllUsers();

    }

    MutableLiveData<List<UserResponse>> userResponsesMutableLiveDate =
            new MutableLiveData<>();

    public void getAllUsers(){

        Call<List<UserResponse>> userList = ApiClient.getUserService().getAllUsers();
        userList.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {

                if (response.isSuccessful()) {
                    List<UserResponse> userResponses = response.body();
                    //usersAdapter.setData(userResponses);
                    userResponsesMutableLiveDate.postValue(userResponses);
                    Log.e("Success", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                Log.e("Failure", t.getLocalizedMessage());
            }
        });

    }
}
