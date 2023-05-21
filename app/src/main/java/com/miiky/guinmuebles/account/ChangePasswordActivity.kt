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

class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        supportActionBar?.hide()
        val email = intent.getStringExtra("email")
        var txtPass = findViewById<EditText>(R.id.txtChangePass)
        var txtRepeatPass = findViewById<EditText>(R.id.txtChangeRepPass)
        var btnChange = findViewById<Button>(R.id.btnChangePass)
        btnChange.setOnClickListener(View.OnClickListener {
            if (txtPass.text.toString().isEmpty() || txtRepeatPass.text.toString().isEmpty()){
                Toast.makeText(this, "Falta algo...", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            if (txtPass.text.toString() != txtRepeatPass.text.toString()){
                Toast.makeText(this, "La contraseña no coincide", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val intent = Intent(this@ChangePasswordActivity, MainActivity::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        })
    }
}