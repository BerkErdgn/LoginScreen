package com.berke.singinandloginapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val actionLogin = MainFragmentDirections.actionMainFragmentToLogInFragment()
        val actionSingIn= MainFragmentDirections.actionMainFragmentToSingInFragment()


        mainFragmentLoginButton.setOnClickListener{
            Navigation.findNavController(it).navigate(actionLogin)
        }

        mainFragmentSingInButton.setOnClickListener{
            Navigation.findNavController(it).navigate(actionSingIn)
        }



    }


}