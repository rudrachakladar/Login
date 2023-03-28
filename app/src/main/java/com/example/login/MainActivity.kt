package com.example.login

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // defining our own password pattern
        var editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        var editTextPassword = findViewById<EditText>(R.id.editTextTextPassword2)
        var buttonLogin = findViewById<Button>(R.id.button3)


        fun isEMailValid(): Boolean {
            val email = editTextEmail.text.toString()
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isPasswordValid(): Boolean {
            val password = editTextPassword.text.toString()

            val pattern =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}$".toRegex()
            return pattern.matches(password)
        }

        buttonLogin.setOnClickListener {
            if (isEMailValid() && isPasswordValid()) {
                // Successful login
                Toast.makeText(this, "Successful Login", Toast.LENGTH_SHORT).show()

            } else {
                // Failed login
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }

        }

    }
}
