package com.example.houyuapp.presentation.main

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.houyuapp.R
import com.example.houyuapp.domain.entity.User
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*
import org.koin.android.ext.android.inject


class RegisterActivity : AppCompatActivity(){

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

       validButton()

    }

    private fun validButton(){

        var test = 0
        mainViewModel.registerLiveData.observe(this, Observer {
            when (it) {
                is RegisterSuccess -> {
                    test = 1
                    Toast.makeText(this, "Register Success!", Toast.LENGTH_SHORT).show()
                }
                is RegisterError -> {
                    AlertDialog.Builder(this)
                        .setTitle("Erreur !")
                        .setMessage("Adresse mail existe déjà\nVeuillez vous inscrire avec une autre adresse mail")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                    test = -1
                }
            }
        })
        valider_button.setOnClickListener{
            val newUserEmail = new_username.text.toString()
            val newUserPassword = new_password.text.toString()
            mainViewModel.verifyRegister(newUserEmail)

            if (test == 1){
                val newUser = User(newUserEmail, newUserPassword)
                mainViewModel.onClickedRegister(newUser)
            }


            findViewById<EditText>(R.id.new_username).text = null
            findViewById<EditText>(R.id.new_password).text = null
        }

//        val editText1 = findViewById<EditText>(R.id.new_username)
//        val editText2 = findViewById<EditText>(R.id.new_password)
//
//        valider_button.setOnClickListener {
//            Toast.makeText(this, editText1.text, Toast.LENGTH_SHORT).show()
//            editText1.text = null
//        }
    }
}