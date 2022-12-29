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

class FragmentDashAdapter(private var fragmentlist: ArrayList<Produk>): RecyclerView.Adapter<FragmentDashAdapter.ViewHolder>(){
    class ViewHolder (view : View): RecyclerView.ViewHolder(view){
        var ivGambar: ImageView = view.findViewById(R.id.iv_gambar)
        var tvMenu: TextView = view.findViewById(R.id.tv_menu)
        var tvDeskripsi: TextView = view.findViewById(R.id.tv_deskripsi)
        var layout: LinearLayout = view.findViewById(R.id.linearLayout_fragment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fragment_template,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivGambar.setImageResource(fragmentlist[position].image)
        holder.tvMenu.text=fragmentlist[position].title
        holder.tvDeskripsi.text=fragmentlist[position].desc


        holder.layout.setOnClickListener{
            val intent = Intent(it.context, DetailProdukActivity::class.java)
            intent.putExtra("gambar", fragmentlist[position].image)
            intent.putExtra("nama", fragmentlist[position].title)
            intent.putExtra("deskripsi", fragmentlist[position].desc)
            intent.putExtra("harga", fragmentlist[position].price)
            it.context.startActivity(intent)
        }

    }
    override fun getItemCount(): Int {
        return fragmentlist.size
    }
}