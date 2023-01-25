package com.berke.singinandloginapp

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_sing_in.*


class SingInFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sing_in, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val action = SingInFragmentDirections.actionSingInFragmentToAfterLoginFragment()


        singInButtonSingInFragment.setOnClickListener{
            var username= usernameTextInSingInFragment.text
            var email = emailTextInSingInFragmetn.text
            var password = passwordTextInSingInFragment.text.toString()
            var confermPassword = passwordComfermTextInSingInFragment.text.toString()

            if(password!= null && confermPassword!=null){
                if (password==confermPassword  ){
                    if (password.length > 8 && confermPassword.length > 8 && Patterns.EMAIL_ADDRESS.matcher(email).matches() && username.toString() != "" ){
                        Navigation.findNavController(it).navigate(action)
                    }else{
                        Toast.makeText(this.context,"Wrong Entiring",Toast.LENGTH_LONG).show()


                    }

                }else{
                    println(password)
                    println(confermPassword)
                    Toast.makeText(this.context,"Password and Confirm Password Does'n Same!!",Toast.LENGTH_LONG).show()

                }

            }else{

                Toast.makeText(this.context,"Please Enter Password and Conferm Password!!",Toast.LENGTH_LONG).show()

            }
        }

        imageView2.setOnClickListener{
            val actionback = SingInFragmentDirections.actionSingInFragmentToMainFragment()
            Navigation.findNavController(it).navigate(actionback)
        }


    }


}