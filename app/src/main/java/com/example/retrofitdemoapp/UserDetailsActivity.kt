package com.example.retrofitdemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_user_details.*

class UserDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (intent.extras?.containsKey("data") == true) {
            val userResponse = intent.getSerializableExtra("data") as UserResponse
            val usernameData = userResponse.username
            val firstnameData = userResponse.id
            val lastnameData = userResponse.date_joined
            val emailData = userResponse.url

            uName.text = usernameData
            firstName.text = firstnameData.toString()
            firstName.setTextColor(resources.getColor(R.color.colorPrimaryDark))
            lastname.text = lastnameData
            lastname.setTextColor(resources.getColor(R.color.colorPrimaryDark))
            email.text = emailData
            email.setTextColor(resources.getColor(R.color.colorPrimaryDark))
        }
    }
}
