package com.ikapurwanti.finalprojectuasbpii.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ikapurwanti.finalprojectuasbpii.R
import com.ikapurwanti.finalprojectuasbpii.model.Produk
import com.ikapurwanti.finalprojectuasbpii.view.detailProduk.DetailProdukActivity

class PoppularCoffeAdapter (private var popularList : ArrayList<Produk>): RecyclerView.Adapter<PoppularCoffeAdapter.ViewHolder>() {

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        var fotoCoffePop: ImageView = view.findViewById(R.id.ivPopular)
        var titleCoffePop: TextView = view.findViewById(R.id.tvTitlePopular)
        var descCoffePop: TextView = view.findViewById(R.id.tvDescPopular)
        var layout: LinearLayout = view.findViewById(R.id.linearLayout_popular)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_popular,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produk = popularList[position]
        holder.fotoCoffePop.setImageResource(produk.image)
        holder.titleCoffePop.text = produk.title
        holder.descCoffePop.text = produk.desc

        holder.layout.setOnClickListener{
            val intent = Intent(it.context, DetailProdukActivity::class.java)
            intent.putExtra("gambar", popularList[position].image)
            intent.putExtra("nama", popularList[position].title)
            intent.putExtra("deskripsi", popularList[position].desc)
            intent.putExtra("harga", popularList[position].price)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return popularList.size
    }
}