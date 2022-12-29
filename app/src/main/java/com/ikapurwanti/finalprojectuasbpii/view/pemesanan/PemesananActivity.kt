package com.ikapurwanti.finalprojectuasbpii.view.pemesanan

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ikapurwanti.finalprojectuasbpii.R
import com.ikapurwanti.finalprojectuasbpii.adapters.PemesananAdapter
import com.ikapurwanti.finalprojectuasbpii.model.Pemesanan
import com.ikapurwanti.finalprojectuasbpii.sql.DatabaseHelper

class PemesananActivity : AppCompatActivity() {

    private lateinit var setNamaKasir : TextView
    private lateinit var edtNamaPro : EditText
    private lateinit var edtHargaPro : EditText
    private lateinit var edtJumlahPro : EditText
    private lateinit var itemListView: ListView
    private lateinit var edtNamaCus : EditText
    private lateinit var edtNoMeja : EditText
    // private lateinit var edtNamaKasir : EditText
    private lateinit var buttonInsert : Button
    private lateinit var tvTotal : TextView

    private val databaseHelper = DatabaseHelper(this, null)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemesanan)

        setNamaKasir = findViewById(R.id.namaKasir)
        edtNamaPro = findViewById(R.id.edtNamaProduk)
        edtHargaPro = findViewById(R.id.edtHargaProduk)
        edtJumlahPro = findViewById(R.id.edtJumlahProduk)
        edtNamaCus = findViewById(R.id.edtNamaCus)
        edtNoMeja = findViewById(R.id.edtNoMeja)
        itemListView = findViewById(R.id.listPemesanan)
        buttonInsert = findViewById(R.id.btnInsert)
        tvTotal = findViewById(R.id.tvTotal)

        val getKasir = intent.getStringExtra("EXTRA_UNAMEKASIR")

        setNamaKasir.text = getKasir

        totalBayar()


        setUpListData()
        Log.e("work", setUpListData().toString())

        buttonInsert.setOnClickListener{ view ->
            addRecord(view)
        }
    }

    private fun totalBayar(){
        val hargaProduk = edtHargaPro.text.toString().trim()
        val jumlahProduk = edtJumlahPro.text.toString().trim()

        val totalBayar = hargaProduk.toDouble() * jumlahProduk.toDouble()

         tvTotal.text = totalBayar.toString()

    }

    private fun addRecord(view: View) {

        val namaProduk = edtNamaPro.text.toString()
        val hargaProduk = edtHargaPro.text.toString()
        val jumlahProduk = edtJumlahPro.text.toString()
        val namaCustomer = edtNamaCus.text.toString()
        val noMeja = edtNoMeja.text.toString()
        val namaKasir = setNamaKasir.text.toString()


        if(namaProduk.isEmpty() && hargaProduk.isEmpty() && jumlahProduk.isEmpty() && namaCustomer.isEmpty() && noMeja.isEmpty()){
            edtNamaPro.error = "Inputkan Nama Produk"
            edtHargaPro.error = "Inputkan Harga Produk"
            edtJumlahPro.error = "Inputkan Jumlah Produk"
            edtNamaCus.error = "Inputkan Nama Customer"
            edtNoMeja.error = "Inputkan Nomor Meja"
        } else if (namaProduk.isEmpty()){
            edtNamaPro.error = "Inputkan Nama Produk"
        } else if (hargaProduk.isEmpty()){
            edtHargaPro.error = "Inputkan Harga Produk"
        } else if (jumlahProduk.isEmpty()){
            edtJumlahPro.error = "Inputkan Jumlah Produk"
        }  else if (namaCustomer.isEmpty()){
            edtNamaCus.error = "Inputkan Nama Customer"
        } else if (noMeja.isEmpty()){
            edtNoMeja.error = "Inputkan Nomor Meja"
        }  else {
            val status = databaseHelper.addPemesanan(
                Pemesanan(0, namaCustomer, Integer.parseInt(noMeja), namaProduk, Integer.parseInt(hargaProduk), Integer.parseInt(jumlahProduk),
                    namaKasir
                ))

            if (status > -1){
                Toast.makeText(this, "$namaProduk Berhasil Ditambahkan Ke Database", Toast.LENGTH_LONG).show()
                edtNamaPro.text.clear()
                edtHargaPro.text.clear()
                edtJumlahPro.text.clear()
                edtNamaCus.text.clear()
                edtNoMeja.text.clear()

                setUpListData()
            } else {
                Toast.makeText(this, "Tidak Berhasil Ditambahkan Ke Database", Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun setUpListData(){
        if(getItemList().size > 0){
            itemListView.visibility = View.VISIBLE

            val itemAdapter = PemesananAdapter(this, getItemList())
            itemListView.adapter = itemAdapter
        } else {
            itemListView.visibility = View.GONE
        }
    }

    private fun getItemList(): ArrayList<Pemesanan> {
        return databaseHelper.getPemesanan()
    }

    fun updateRecordDialog(data : Pemesanan){
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogViewPemesanan = inflater.inflate(R.layout.update_pesanan_dialog, null)
        dialogBuilder.setView(dialogViewPemesanan)

        val etupdateNamePro : EditText = dialogViewPemesanan.findViewById(R.id.updateNamaProduk)
        val etupdateHargaPro : EditText = dialogViewPemesanan.findViewById(R.id.updateHargaProduk)
        val etupdateJumlahPro : EditText = dialogViewPemesanan.findViewById(R.id.updateJumlahProduk)
        val etupdateNameCus : EditText = dialogViewPemesanan.findViewById(R.id.updateNamaCus)
        val etupdateNoMeja : EditText = dialogViewPemesanan.findViewById(R.id.updateNoMeja)
        //val etupdateNamaKasir : EditText = dialogViewPemesanan.findViewById(R.id.updateNamaKasir)

        etupdateNamePro.setText(data.produk)
        etupdateHargaPro.setText(data.harga.toString())
        etupdateJumlahPro.setText(data.jumlah.toString())
        etupdateNameCus.setText(data.cus)
        etupdateNoMeja.setText(data.noMeja.toString())
      //  etupdateNamaKasir.setText(data.kasir)
        dialogBuilder.setTitle("Update Data")
        dialogBuilder.setIcon(R.drawable.edit_icon)

        dialogBuilder.setPositiveButton(
            "Update",
            DialogInterface.OnClickListener{ dialogInterface, _ ->
                val updateNamaPro = etupdateNamePro.text.toString()
                val updateHargaPro = etupdateHargaPro.text.toString()
                val updateJumlahPro = etupdateJumlahPro.text.toString()
                val updateNamaCus = etupdateNameCus.text.toString()
                val updateNoMeja = etupdateNoMeja.text.toString()
             //   val updateNamaKasir = etupdateNamaKasir.text.toString()

                if(updateNamaPro.isEmpty() && updateHargaPro.isEmpty() && updateJumlahPro.isEmpty() && updateNamaCus.isEmpty() && updateNoMeja.isEmpty() ){
                    etupdateNamePro.error = "Inputkan Nama Produk"
                    etupdateHargaPro.error = "Inputkan Harga Produk"
                    etupdateJumlahPro.error = "Inputkan Jumlah Produk"
                    etupdateNameCus.error = "Inputkan Nama Customer"
                    etupdateNoMeja.error = "Inputkan Nomor Meja"
                    //etupdateNamaKasir.error = "Inputkan Nama Kasir"
                } else if (updateNamaPro.isEmpty()){
                    etupdateNamePro.error = "Inputkan Nama Produk"
                } else if (updateHargaPro.isEmpty()){
                    etupdateHargaPro.error = "Inputkan Harga Produk"
                }else if (updateJumlahPro.isEmpty()){
                    etupdateJumlahPro.error = "Inputkan Jumlah Produk"
                }  else if (updateNamaCus.isEmpty()){
                    etupdateNameCus.error = "Inputkan Nama Customer"
                } else if (updateNoMeja.isEmpty()){
                    etupdateNoMeja.error = "Inputkan Nomor Meja"
                } else {
                    val status =  databaseHelper.updatePemesan(
                        Pemesanan(data.id, updateNamaCus, Integer.parseInt(updateNoMeja), updateNamaPro, Integer.parseInt(updateHargaPro),
                            Integer.parseInt(updateJumlahPro),
                            setNamaKasir.toString()
                        ))

                    if(status > -1){
                        Toast.makeText(this, "Id: ${data.id} Berhasil Diupdate", Toast.LENGTH_LONG).show()
                        etupdateNamePro.text.clear()
                        etupdateHargaPro.text.clear()
                        etupdateJumlahPro.text.clear()
                        etupdateNameCus.text.clear()
                        etupdateNoMeja.text.clear()
                       // etupdateNamaKasir.text.clear()

                        setUpListData()
                    } else {
                        Toast.makeText(this, "Id: ${data.id} Tidak Berhasil Diupdate", Toast.LENGTH_LONG).show()
                    }
                }
            }
        )
        dialogBuilder.setNegativeButton("Cancel"){ dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        dialogBuilder.show()
    }

    fun deleteRecordDialog(data: Pemesanan) {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Hapus Data")
        builder.setMessage("Apakah Anda Ingin Hapus ${data.produk}?")

        builder.setIcon(R.drawable.ic_baseline_warning_24)

        builder.setPositiveButton("Yes"){
                dialogInterface, _ ->
            val status = databaseHelper.deletePemesanan(Pemesanan(data.id, "", 0, "", 0, 0, data.kasir ))

            if (status > -1 ){
                Toast.makeText(this, "Data Berhasil Didelete", Toast.LENGTH_LONG).show()
                setUpListData()
            }
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No"){
                dialogInterface, _ -> dialogInterface.dismiss()
        }
        val alertDialog : AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

}