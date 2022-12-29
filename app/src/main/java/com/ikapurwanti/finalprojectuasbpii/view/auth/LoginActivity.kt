package com.ikapurwanti.finalprojectuasbpii.view.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ikapurwanti.finalprojectuasbpii.R
import com.ikapurwanti.finalprojectuasbpii.view.home.DashboardActivity
import com.ikapurwanti.finalprojectuasbpii.view.pemesanan.PemesananActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_login = findViewById(R.id.btn_login) as Button

        val uname = findViewById<EditText>(R.id.edtUnameKasir).text.toString()

        btn_login.setOnClickListener() {

//            kasir()
            val uname = findViewById<EditText>(R.id.edtUnameKasir).text.toString()
            val pass = findViewById<EditText>(R.id.edtPassword).text.toString()

            val username = "ruru"
            val password = "ruru01"

            val nama = uname

            // nama.putString("EXTRAX_UNAMEKASIR")

            if (uname == username && pass == password) {
                val args = Intent(this, DashboardActivity::class.java)
                    args.putExtra("EXTRA_UNAMEKASIR", nama)
                    startActivity(args)

                Toast.makeText(this, "$username Berhasil login", Toast.LENGTH_SHORT).show()
            } else if (uname == "" && pass == "") {
                Toast.makeText(this, "Silakan inputkan username dan password", Toast.LENGTH_SHORT)
                    .show()
            } else if (uname != username) {
                Toast.makeText(this, "Username yang diinputkan salah", Toast.LENGTH_SHORT).show()
            } else if (pass != password) {
                Toast.makeText(this, "Password yang diinputkan salah", Toast.LENGTH_SHORT).show()
            }




//                startActivity(it)

            }

        }

    }
