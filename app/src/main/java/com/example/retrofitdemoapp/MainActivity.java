package com.example.retrofitdemoapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements UsersAdapter.ClickedItem{

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        UserFragmentList userFragmentList = new UserFragmentList();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.placeHolder, userFragmentList);
        fragmentTransaction.commit();
    }


    @Override
    public void ClickedUser(UserResponse userResponse) {
        startActivity(new Intent(this, UserDetailsActivity.class).putExtra("data", userResponse));
    }

}
