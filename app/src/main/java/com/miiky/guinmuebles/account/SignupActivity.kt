package com.miiky.guinmuebles.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.miiky.guinmuebles.MainActivity
import com.miiky.guinmuebles.R

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        supportActionBar?.hide()

        var txtUser = findViewById<EditText>(R.id.txtSignUser)
        var txtEmail = findViewById<EditText>(R.id.txtSignEmail)
        var txtPass = findViewById<EditText>(R.id.txtSignPass)
        var txtRepPass = findViewById<EditText>(R.id.txtSignRepPass)
        var txtName = findViewById<EditText>(R.id.txtSignName)
        var txtLast = findViewById<EditText>(R.id.txtSignLastname)

        var btnSign = findViewById<Button>(R.id.btnSignUP)

        var email = intent.getStringExtra("email")

        txtEmail.setText(email)

        btnSign.setOnClickListener(View.OnClickListener {
            var left = resources.getString(R.string.left) + ": "
            if (txtUser.text.toString().isEmpty()){
                left += resources.getString(R.string.username) + " "
            }
            if (txtEmail.text.toString().isEmpty()){
                left += resources.getString(R.string.email) + " "
            }
            if (txtPass.text.toString().isEmpty()){
                left += resources.getString(R.string.password)
            }
            if (txtRepPass.text.toString().isEmpty()){
                left += resources.getString(R.string.repeatpassword) + " "
            }
            if (txtName.text.toString().isEmpty()){
                left += resources.getString(R.string.name) + " "
            }
            if (txtLast.text.toString().isEmpty()){
                left += resources.getString(R.string.lastname) + " "
            }
            if (!left.equals(resources.getString(R.string.left) + ": ")){
                Toast.makeText(this, left, Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            if (txtPass.text.toString() != txtRepPass.text.toString()){
                Toast.makeText(this, "La contraseña no coincide", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val intent = Intent(this@SignupActivity, MainActivity::class.java)
            intent.putExtra("email", txtEmail.text.toString())
            startActivity(intent)
        })
    }
}