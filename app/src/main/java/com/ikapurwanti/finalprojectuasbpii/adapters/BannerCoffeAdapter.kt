package com.ikapurwanti.finalprojectuasbpii.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ikapurwanti.finalprojectuasbpii.R
import com.ikapurwanti.finalprojectuasbpii.model.Produk
import com.ikapurwanti.finalprojectuasbpii.view.detailProduk.DetailProdukActivity

class BannerCoffeAdapter (private var bannerList : ArrayList<Produk>): RecyclerView.Adapter<BannerCoffeAdapter.ViewHolder>() {

    class ViewHolder(view : View): RecyclerView.ViewHolder(view) {
        var fotoCoffe: ImageView = view.findViewById(R.id.img_content)
        var judulCoffe: TextView = view.findViewById(R.id.tv_judul)
        var deskripsiCoffe: TextView = view.findViewById(R.id.tv_deskripsi)
        var hargaCoffe: TextView = view.findViewById(R.id.tv_harga)
        var card: CardView = view.findViewById(R.id.card_banner)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_banner,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fotoCoffe.setImageResource(bannerList[position].image)
        holder.judulCoffe.text = bannerList[position].title
        holder.deskripsiCoffe.text = bannerList[position].desc
        holder.hargaCoffe.text = bannerList[position].price.toString()

        holder.card.setOnClickListener{
            val intent = Intent(it.context, DetailProdukActivity::class.java)
            intent.putExtra("gambar", bannerList[position].image)
            intent.putExtra("nama", bannerList[position].title)
            intent.putExtra("deskripsi", bannerList[position].desc)
            intent.putExtra("harga", bannerList[position].price)
            it.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return bannerList.size
    }
}