package com.example.retrofitdemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetailsActivity extends AppCompatActivity {

    TextView username, firstname, lastname, email;
    UserResponse userResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (TextView)findViewById(R.id.uName);
        firstname = (TextView)findViewById(R.id.firstName);
        lastname = (TextView)findViewById(R.id.lastname);
        email = (TextView)findViewById(R.id.email);

        Intent intent = getIntent();
        if(intent.getExtras() != null) {
            userResponse = (UserResponse) intent.getSerializableExtra("data");
            String usernameData = userResponse.getUsername();
            int firstnameData = userResponse.getId();
            String lastnameData = userResponse.getDate_joined();
            String emailData = userResponse.getUrl();

            username.setText(usernameData);
            firstname.setText(firstnameData+"");
            firstname.setTextColor(this.getResources().getColor(R.color.colorPrimaryDark));
            lastname.setText(lastnameData);
            lastname.setTextColor(this.getResources().getColor(R.color.colorPrimaryDark));
            email.setText(emailData);
            email.setTextColor(this.getResources().getColor(R.color.colorPrimaryDark));

        }
    }
}