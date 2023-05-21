package com.miiky.guinmuebles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.miiky.guinmuebles.account.ForgotActivity
import com.miiky.guinmuebles.account.SignupActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        supportActionBar?.hide()

        var email = intent.getStringExtra("email")

        var btnForgot = findViewById<Button>(R.id.btnForgot)
        var btnLogin = findViewById<Button>(R.id.btnLogin)
        var btnSignup = findViewById<Button>(R.id.btnSignup)

        val txtEmail = findViewById<EditText>(R.id.txtLoginEmail)
        val txtPass = findViewById<EditText>(R.id.txtLoginPass)

        txtEmail.setText(email)

        val pEmail = Patterns.EMAIL_ADDRESS

        btnForgot.setOnClickListener(View.OnClickListener {
            if(txtEmail.text.toString().isEmpty()){
                val intent = Intent(this@MainActivity, ForgotActivity::class.java)
                startActivity(intent)
                return@OnClickListener
            }
            if(txtEmail.text.toString().isNotEmpty() && !pEmail.matcher(txtEmail.text.toString()).matches()){
                Toast.makeText(this, resources.getString(R.string.emailnotvaliid), Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val intent = Intent(this@MainActivity, ForgotActivity::class.java)
            intent.putExtra("email", txtEmail.text.toString())
            startActivity(intent)
        })

        btnSignup.setOnClickListener(View.OnClickListener {
            if(txtEmail.text.toString().isEmpty()){
                val intent = Intent(this@MainActivity, SignupActivity::class.java)
                startActivity(intent)
                return@OnClickListener
            }
            if(txtEmail.text.toString().isNotEmpty() && !pEmail.matcher(txtEmail.text.toString()).matches()){
                Toast.makeText(this, resources.getString(R.string.emailnotvaliid), Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val intent = Intent(this@MainActivity, SignupActivity::class.java)
            intent.putExtra("email", txtEmail.text.toString())
            startActivity(intent)
        })

        btnLogin.setOnClickListener(View.OnClickListener {
            var left = resources.getString(R.string.left) + ": "
            if (txtEmail.text.toString().isEmpty()){
                left += resources.getString(R.string.email) + " "
            }
            if (txtPass.text.toString().isEmpty()){
                left += resources.getString(R.string.password)
            }
            if (!left.equals(resources.getString(R.string.left) + ": ")){
                Toast.makeText(this, left, Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            if(txtEmail.text.toString().isNotEmpty() && !pEmail.matcher(txtEmail.text.toString()).matches()){
                Toast.makeText(this, resources.getString(R.string.emailnotvaliid), Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val intent = Intent(this@MainActivity, MasterActivity::class.java)
            startActivity(intent)
        })
    }
}