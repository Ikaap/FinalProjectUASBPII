package com.ikapurwanti.finalprojectuasbpii.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ikapurwanti.finalprojectuasbpii.R
import com.ikapurwanti.finalprojectuasbpii.adapters.BannerCoffeAdapter
import com.ikapurwanti.finalprojectuasbpii.adapters.PoppularCoffeAdapter
import com.ikapurwanti.finalprojectuasbpii.model.Produk

class AllFragment : Fragment() {

    private lateinit var adapterBanner : BannerCoffeAdapter
    private lateinit var adapterPoppular : PoppularCoffeAdapter
    private lateinit var recyclerViewBanner : RecyclerView
    private lateinit var recyclerViewPoppular: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBanner()
        dataPoppular()

        val layoutManagerBanner = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewBanner = view.findViewById(R.id.rv_banner) as RecyclerView
        recyclerViewBanner.layoutManager = layoutManagerBanner
        recyclerViewBanner.setHasFixedSize(true)
        recyclerViewBanner.adapter = adapterBanner

        val layoutManagerPopular = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerViewPoppular = view.findViewById(R.id.rv_popular) as RecyclerView
        recyclerViewPoppular.layoutManager = layoutManagerPopular
        recyclerViewPoppular.setHasFixedSize(true)
        recyclerViewPoppular.adapter = adapterPoppular
    }


    private fun dataBanner(){
        val listBanner = arrayListOf<Produk>()

        listBanner.add(Produk(R.drawable.coffe1,"Cappucino","Espresso, Steamed milk",25000))
        listBanner.add(Produk(R.drawable.coffe2,"Es Latte","Espresso, Steamed milk",20000))
        listBanner.add(Produk(R.drawable.coffe3,"Flat White","Espresso, Foam",15000))
        listBanner.add(Produk(R.drawable.coffe4,"Ice Americano","Espresso, Cold Wter",40000))
        listBanner.add(Produk(R.drawable.coffe5,"Doppio","2 0z Espresso",35000))
        listBanner.add(Produk(R.drawable.coffe6,"Lungo","Long Pulled Espresso",25000))

        adapterBanner = BannerCoffeAdapter(listBanner)
    }

    private fun dataPoppular() {
        val listPoppular = arrayListOf<Produk>()

        listPoppular.add(Produk(R.drawable.coffe5,"Doppio","2 Oz Espresso", 35000))
        listPoppular.add(Produk(R.drawable.coffe6,"Lungo","Long Pulled Espresso", 25000))
        listPoppular.add(Produk(R.drawable.coffe7,"Machiato","Espresso Shot, Foam", 10000))
        listPoppular.add(Produk(R.drawable.coffe8,"Milk Coffee","Hot and Ice Water", 13000))
        listPoppular.add(Produk(R.drawable.coffe9,"Black","Just Coffee", 17000))

        adapterPoppular = PoppularCoffeAdapter(listPoppular)
    }


}