package com.ikapurwanti.finalprojectuasbpii.view.detailProduk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.ikapurwanti.finalprojectuasbpii.R
import com.ikapurwanti.finalprojectuasbpii.view.home.DashboardActivity

class DetailProdukActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)

        val ivback : ImageView = findViewById(R.id.iv_back_dash)
        ivback.setOnClickListener{
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        val setGambar : ImageView = findViewById(R.id.imageproduct)
        val setNama : TextView = findViewById(R.id.tvName)
        val setDeskripsi : TextView = findViewById(R.id.tvDesc)
        val setHarga: TextView = findViewById(R.id.tvPrice)

        val getItem = intent
        val getGambar = getItem.getIntExtra("gambar", 0)
        val getNama = getItem?.getStringExtra("nama")
        val getDes = getItem?.getStringExtra("deskripsi")
        val getHarga = getItem?.getIntExtra("harga", 0)

        setGambar.setImageResource(getGambar)
        setNama.text = getNama
        setDeskripsi.text = getDes
        setHarga.text = getHarga.toString()
    }
}