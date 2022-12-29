package com.ikapurwanti.finalprojectuasbpii.model

import android.widget.TextView

data class Pemesanan(
    val id: Int,
    val cus: String,
    val noMeja: Int,
    val produk: String,
    val harga: Int,
    val jumlah: Int,
    val kasir: String

)

