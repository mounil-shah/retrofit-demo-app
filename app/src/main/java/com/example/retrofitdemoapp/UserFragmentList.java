package com.example.retrofitdemoapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragmentList extends Fragment implements UsersAdapter.ClickedItem{

    public UserFragmentList() {
        // Required empty public constructor
    }
    UsersAdapter usersAdapter;
    UsersViewModel usersViewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        RecyclerView recyclerView  = getView().findViewById(R.id.userList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        usersAdapter = new UsersAdapter(this);
        recyclerView.setAdapter(usersAdapter);
        usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
        usersViewModel.getUserResponsesLiveDate().observe(getViewLifecycleOwner(), userResponses -> {
            if (userResponses != null)
                usersAdapter.setData(userResponses);
        });

        usersViewModel.getUserResponseErrorLiveData().observe(getViewLifecycleOwner(), error -> {
            if (error != null)
                Toast.makeText(requireContext(), "User List couldn't be fetched", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        return view;
    }

    @Override
    public void ClickedUser(UserResponse userResponse) {
        Toast.makeText(getContext(), "This is clicked", Toast.LENGTH_LONG).show();
        Bundle bundle = new Bundle();
        UserDetailsFragment userDetails = new UserDetailsFragment();
        bundle.putString("username", userResponse.getUsername());
        bundle.putString("firstname", userResponse.getId()+"");
        bundle.putString("lastname", userResponse.getDate_joined());
        bundle.putString("userurl", userResponse.getUrl());
        userDetails.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, userDetails);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}