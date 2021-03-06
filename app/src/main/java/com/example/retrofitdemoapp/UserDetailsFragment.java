package com.example.retrofitdemoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class UserDetailsFragment extends Fragment {

    TextView userName, FirstName, dateJoined, userURL;
    UserResponse userResponse;
    UsersViewModel usersViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_user_details, container, false);
        userName = view.findViewById(R.id.uName);
        FirstName = view.findViewById(R.id.firstName);
        dateJoined = view.findViewById(R.id.lastname);
        userURL = view.findViewById(R.id.email);

        Bundle bundle = new Bundle();
        bundle = getArguments();
        String userNames = bundle.getString("username");
        String firstNames = bundle.getString("firstname");
        String lastNames = bundle.getString("lastname");
        String userUrl = bundle.getString("userurl");

        usersViewModel = new UsersViewModel();

//        usersViewModel.getData().observe(this, new Observer<ApiResponse>() {
//            @Override
//            public void onChanged(ApiResponse apiResponse) {
//                if (apiResponse == null) {
//                    Throwable t = apiResponse.getError();
//                    Log.e("Error", "Error is " + t.getLocalizedMessage());
//                } else if (apiResponse.getError() == null) {
//                    userName.setText(userNames);
//                    FirstName.setText(firstNames);
//                    dateJoined.setText(lastNames);
//                    userURL.setText(userUrl);
//                } else {
//                    Throwable r = apiResponse.getError();
//                    Toast.makeText(getActivity(), "Unable to retrive data", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

//        usersViewModel.getUserResponsesLiveDate().observe(this, new Observer<List<UserResponse>>() {
//            @Override
//            public void onChanged(List<UserResponse> userResponses) {
//                if (userResponses != null)
//                    userName.setText(userNames);
//                    FirstName.setText(firstNames);
//                    dateJoined.setText(lastNames);
//                    userURL.setText(userUrl);
//            }
//        });

        return view;
    }
}