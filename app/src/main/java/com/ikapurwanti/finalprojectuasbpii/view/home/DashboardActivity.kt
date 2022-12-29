package com.ikapurwanti.finalprojectuasbpii.view.home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.ikapurwanti.finalprojectuasbpii.R
import com.ikapurwanti.finalprojectuasbpii.fragment.AllFragment
import com.ikapurwanti.finalprojectuasbpii.fragment.DrinkFragment
import com.ikapurwanti.finalprojectuasbpii.fragment.FoodFragment
import com.ikapurwanti.finalprojectuasbpii.view.pemesanan.PemesananActivity

class DashboardActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // intent ke pemesanan
        val btnpemesanan = findViewById<ImageView>(R.id.iv_pemesanan)

        val namaKasir = findViewById<TextView>(R.id.textView4)

        val getKasir = intent.getStringExtra("EXTRA_UNAMEKASIR")
        namaKasir.text = getKasir

        val unameKasir = findViewById<TextView>(R.id.textView4).text.toString()
        val usernama = unameKasir


        btnpemesanan.setOnClickListener {
            val intent = Intent(this, PemesananActivity::class.java)
            startActivity(intent)

            val args = Intent(this, PemesananActivity::class.java)
            args.putExtra("EXTRA_UNAMEKASIR", usernama)
            startActivity(args)
        }


        // fragment
        val fragmentall = AllFragment()
        val fragmentdrink = DrinkFragment()
        val fragmentfood = FoodFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout,fragmentall)
            commit()
        }

        val tvDrink = findViewById<TextView>(R.id.tv_drink)
        val tvFood = findViewById<TextView>(R.id.tv_food)
        val tvAll = findViewById<TextView>(R.id.tv_all)

        tvAll.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout,fragmentall)
            fragmentTransaction.commit()
        }

        tvDrink.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout,fragmentdrink)
            fragmentTransaction.commit()
        }

        tvFood.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout,fragmentfood)
            fragmentTransaction.commit()
        }
    }


}