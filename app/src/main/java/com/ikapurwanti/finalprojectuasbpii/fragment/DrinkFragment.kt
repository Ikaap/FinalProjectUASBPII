package com.ikapurwanti.finalprojectuasbpii.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ikapurwanti.finalprojectuasbpii.R
import com.ikapurwanti.finalprojectuasbpii.adapters.FragmentDashAdapter
import com.ikapurwanti.finalprojectuasbpii.model.Produk

class DrinkFragment : Fragment() {

    private lateinit var adapter : FragmentDashAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataDrink()
        val layoutManager = LinearLayoutManager(activity)
        recyclerView = view.findViewById(R.id.recycler_view_drink)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

    }

    private fun dataDrink(){

        val listDrink = arrayListOf<Produk>()

        listDrink.add(Produk(R.drawable.coffe1,"Cappucino","Espresso, Steamed milk", 25000))
        listDrink.add(Produk(R.drawable.coffe2,"Es Latte","Espresso, Steamed milk", 20000))
        listDrink.add(Produk(R.drawable.coffe3,"Flat Whiite","Espresso, Foam", 15000))
        listDrink.add(Produk(R.drawable.coffe4,"Ice Americano","Espresso, Cold Water", 40000))
        listDrink.add(Produk(R.drawable.coffe5,"Doppio","2 Oz Espresso", 35000))
        listDrink.add(Produk(R.drawable.coffe6,"Lungo","Long Pulled Espresso", 25000))
        listDrink.add(Produk(R.drawable.coffe7,"Machiato","Espresso Shot, Foam", 10000))
        listDrink.add(Produk(R.drawable.coffe8,"Milk Coffee","Hot and Ice Water", 13000))
        listDrink.add(Produk(R.drawable.coffe9,"Black","Just Coffee", 17000))
        listDrink.add(Produk(R.drawable.coffe10,"Dalgona Coffee","Milo, Coffee", 24000))
        listDrink.add(Produk(R.drawable.coffe11,"Mocha","Espresso, Cocholate, Steamed Milk ", 20000))
        listDrink.add(Produk(R.drawable.coffe12,"Ice Coffee Caramel","1 Oz Espresso, 1 Oz Steamed Milk", 30000))
        listDrink.add(Produk(R.drawable.coffe13,"Chocolate","Coffee, Vanilla", 35000))

        adapter = FragmentDashAdapter(listDrink)
    }
}