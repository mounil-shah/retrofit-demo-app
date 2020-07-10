package com.example.retrofitdemoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_user_list.*

class UserFragmentList : Fragment() {
    var usersAdapter: UsersAdapter? = null
    val usersViewModel by activityViewModels<UsersViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        usersAdapter = UsersAdapter(lambdaForItemClick)
        userList.layoutManager = LinearLayoutManager(activity)
        userList.adapter = usersAdapter
        usersViewModel.getUserResponsesLiveData().observe(viewLifecycleOwner, Observer { userResponses: List<UserResponse>? -> if (userResponses != null) usersAdapter!!.setData(userResponses) })
        usersViewModel.getUserResponseErrorLiveData().observe(viewLifecycleOwner, Observer { error: String? -> if (error != null) Toast.makeText(requireContext(), "User List couldn't be fetched", Toast.LENGTH_LONG).show() })
    }

    val lambdaForItemClick = { userResponse: UserResponse ->
        usersViewModel.setSelectedUser(userResponse)
        val userDetails = UserDetailsFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.placeHolder, userDetails)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
        Unit
    }

}