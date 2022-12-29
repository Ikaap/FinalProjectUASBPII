package com.ikapurwanti.finalprojectuasbpii.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ikapurwanti.finalprojectuasbpii.R
import com.ikapurwanti.finalprojectuasbpii.model.Pemesanan
import com.ikapurwanti.finalprojectuasbpii.view.pemesanan.PemesananActivity

class PemesananAdapter(
    private val context: Activity,
    private val items : ArrayList<Pemesanan>
) : ArrayAdapter<String>(context, R.layout.list_items_pesan) {

    @SuppressLint("MissingInflatedId", "ViewHolder", "SetTextI18n", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup) : View {
        val item = items[position]

        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.list_items_pesan, null, true)

        val namepro = rowView.findViewById<TextView>(R.id.namaProduk)
        val hargapro = rowView.findViewById<TextView>(R.id.hargaProduk)
        val jumlahpro = rowView.findViewById<TextView>(R.id.jumlahProduk)
        val namecus = rowView.findViewById<TextView>(R.id.tvCus)
        val nomeja = rowView.findViewById<TextView>(R.id.tvNoMeja)
        var namekasir = rowView.findViewById<TextView>(R.id.tvKasir)

        val buttonupdate = rowView.findViewById<ImageView>(R.id.editRecord)
        val buttondelete = rowView.findViewById<ImageView>(R.id.deleteRecord)

        namepro.text = "Nama Produk : ${item.produk}"
        hargapro.text = "Harga Produk : ${item.harga}"
        jumlahpro.text = "Jumlah Produk : ${item.jumlah}"
        namecus.text = "${item.cus}"
        nomeja.text = "${item.noMeja}"
//
//        val intent = null
//        namekasir = intent.getStringExtra("")
        namekasir.text = "${item.kasir}"

        buttonupdate.setOnClickListener{ view ->
            if (context is PemesananActivity){
                context.updateRecordDialog(item)
            }
        }
        buttondelete.setOnClickListener{ view ->
            if (context is PemesananActivity){
                context.deleteRecordDialog(item)
            }
        }
        return rowView
    }

    override fun getCount(): Int {
        return items.size
    }
}