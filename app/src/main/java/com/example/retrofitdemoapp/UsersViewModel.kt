package com.example.retrofitdemoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsersViewModel : ViewModel() {
    private val userRepository = UserRepositoryRetrofit()
    private val selectedUserMutableLiveData = MutableLiveData<UserResponse>()

    fun getSelectedUserLiveData(): LiveData<UserResponse> = selectedUserMutableLiveData
    fun setSelectedUser(userResponse: UserResponse) {
        selectedUserMutableLiveData.postValue(userResponse)
    }
    fun getUserResponsesLiveData() = userRepository.userListLiveData

    fun getUserResponseErrorLiveData() = userRepository.userListErrorLiveData

}