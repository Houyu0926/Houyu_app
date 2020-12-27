package com.example.houyuapp.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.houyuapp.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private var mExitTime: Long = 0
    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton()
        registerButton()

    }

    private fun loginButton(){
        mainViewModel.loginLiveData.observe(this, Observer {
            when (it) {
                is LoginSuccess -> {
                    // TODO
                }
                LoginError -> {
                    AlertDialog.Builder(this)
                        .setTitle("Erreur !")
                        .setMessage("Adresse email inconnu\nVeuillez créer un compte ~")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(username.text.toString().trim(), password.text.toString())
        }
    }

    private fun registerButton() {

        create_account_button.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            this@MainActivity.startActivity(intent)
        })
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (System.currentTimeMillis() - mExitTime > 2000) {

                Toast.makeText(this, "Press again to exit the APP ~", Toast.LENGTH_SHORT).show()
                mExitTime = System.currentTimeMillis()
            } else {
                finish()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}