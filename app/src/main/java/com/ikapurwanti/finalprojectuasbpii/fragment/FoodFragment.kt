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

class FoodFragment : Fragment() {

    private lateinit var adapter : FragmentDashAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataFood()
        val layoutManager = LinearLayoutManager(activity)
        recyclerView = view.findViewById(R.id.recycler_view_food)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    private fun dataFood(){

        val listFood = arrayListOf<Produk>()

        listFood.add(Produk(R.drawable.food1,"Croffle","Bread, Ice Cream", 20000))
        listFood.add(Produk(R.drawable.food2,"Pastry Dessert","Fruit, Pastry", 50000))
        listFood.add(Produk(R.drawable.food3,"Fried Potato","Potato, Salt", 25000))
        listFood.add(Produk(R.drawable.food4,"Toast","Bread, Fruit", 37000))
        listFood.add(Produk(R.drawable.food5,"Chocolate Slice Cake","Bread, Chocolate", 35000))
        listFood.add(Produk(R.drawable.food6,"Pasta","Noodle, Carbonara", 60000))
        listFood.add(Produk(R.drawable.food7,"Chicken Wings","Chicken, Black Sauce", 55000))
        listFood.add(Produk(R.drawable.food8,"Onion Ring","Onion, Sauce, Spice", 15000))
        listFood.add(Produk(R.drawable.food9,"Dimsum","Beef, Fish", 18000))
        listFood.add(Produk(R.drawable.food10,"Fried Banana","Banana, Cheese, Chocolate", 15000))

        adapter = FragmentDashAdapter(listFood)
    }
}