package com.example.retrofitdemoapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import com.example.retrofitdemoapp.UsersAdapter.ClickedItem

class MainActivity : FragmentActivity(), ClickedItem {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userFragmentList = UserFragmentList()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.placeHolder, userFragmentList)
        fragmentTransaction.commit()
    }

    override fun ClickedUser(userResponse: UserResponse) {
        startActivity(Intent(this, UserDetailsActivity::class.java).putExtra("data", userResponse))
    }
}