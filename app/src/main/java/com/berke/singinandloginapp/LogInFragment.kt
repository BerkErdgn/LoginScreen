package com.berke.singinandloginapp

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_log_in.*


class LogInFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val actionAfterLogin = LogInFragmentDirections.actionLogInFragmentToAfterLoginFragment()
        val actionForget = LogInFragmentDirections.actionLogInFragmentToForgetPasswordFragment()
        val email = emailTextInLogin.text
        val password = loginPassowordText.text
        val deneme = emailTextInLogin.text

        loginFragmnetLoginBotton.setOnClickListener{
            if (password != null){
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()&& password.length >8){
                Navigation.findNavController(it).navigate(actionAfterLogin)
            }else{
                println("a")
                println(deneme)
                println("${email}")
                println("${password}")
                Toast.makeText(this.context,"Wrong Email or Password!!",Toast.LENGTH_LONG).show()
            }
            }else{
                Toast.makeText(this.context,"Pleas Enter Password!!",Toast.LENGTH_LONG).show()
            }

        }

        forgetPasswordTextView.setOnClickListener{
            Navigation.findNavController(it).navigate(actionForget)
        }

        imageView.setOnClickListener{
            val actionBack = LogInFragmentDirections.actionLogInFragmentToMainFragment()
            Navigation.findNavController(it).navigate(actionBack)
        }

    }
}