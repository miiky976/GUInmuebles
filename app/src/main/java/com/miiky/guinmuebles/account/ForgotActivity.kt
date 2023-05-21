package com.miiky.guinmuebles.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.miiky.guinmuebles.R

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        supportActionBar?.hide()

        var btnGetCode = findViewById<Button>(R.id.btnGetCode)
        var btnChangePass = findViewById<Button>(R.id.btnChangePass)

        var txtEmail = findViewById<EditText>(R.id.txtForgotEmail)
        var txtCode = findViewById<EditText>(R.id.txtCode)
        val email = intent.getStringExtra("email")

        val pEmail = Patterns.EMAIL_ADDRESS

        txtEmail.setText(email)

        btnGetCode.setOnClickListener(View.OnClickListener {
            if (txtEmail.text.toString().isEmpty()){
                Toast.makeText(this, "Falta el correo", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            if(txtEmail.text.toString().isNotEmpty() && !pEmail.matcher(txtEmail.text.toString()).matches()){
                Toast.makeText(this, resources.getString(R.string.emailnotvaliid), Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            txtCode.isEnabled = true
            btnChangePass.isEnabled = true
        })
        btnChangePass.setOnClickListener(View.OnClickListener {
            if (txtCode.text.toString().isEmpty() || !txtCode.text.toString().equals("1234")){
                Toast.makeText(this, resources.getString(R.string.codenotvalid), Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val intent = Intent(this@ForgotActivity, ChangePasswordActivity::class.java)
            intent.putExtra("email", txtEmail.text.toString())
            startActivity(intent)
        })
    }
}