package com.example.retrofitdemoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_user_details.*

class UserDetailsFragment : Fragment() {
    val usersViewModel by activityViewModels<UsersViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user_details, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        usersViewModel.getSelectedUserLiveData().observe(viewLifecycleOwner, Observer { userResponse ->
            uName.text = userResponse.username
            firstName.text = userResponse.first_name
            lastname.text = userResponse.last_name
            email.text = userResponse.email
        })
    }
}

