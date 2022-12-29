package com.ikapurwanti.finalprojectuasbpii.sql

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.ikapurwanti.finalprojectuasbpii.model.Pemesanan
import com.ikapurwanti.finalprojectuasbpii.view.auth.LoginActivity

class DatabaseHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        // buat table user
        val create = ("CREATE TABLE " + TABLE_PEMESANAN + "(" +
                COLUMN_ID_PESAN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER + " TEXT, " + COLUMN_NO_MEJA + " INTEGER, " +
                COLUMN_PRODUK + " TEXT, " + COLUM_HARGA_PRODUK + " INTEGER, " + COLUMN_JUMLAH + " INTEGER, " +
                COLUMN_KASIR + " TEXT" + ")")
        db.execSQL(create)

    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PEMESANAN")
        onCreate(db)
    }

    fun addPemesanan(dataPesan: Pemesanan): Long {
        val db = this.writableDatabase
        val data = ContentValues()
        data.put(COLUMN_USER, dataPesan.cus)
        data.put(COLUMN_NO_MEJA, dataPesan.noMeja)
        data.put(COLUMN_PRODUK, dataPesan.produk)
        data.put(COLUM_HARGA_PRODUK, dataPesan.harga)
        data.put(COLUMN_JUMLAH, dataPesan.jumlah)
        data.put(COLUMN_KASIR, dataPesan.kasir)

        val insert = db.insert(TABLE_PEMESANAN, null, data)
        db.close()
        return insert

    }

    @SuppressLint("Range", "Recycle")
    fun getPemesanan() : ArrayList<Pemesanan> {

        val pesanList: ArrayList<Pemesanan> = ArrayList<Pemesanan>()
        val selectAll = "SELECT * FROM $TABLE_PEMESANAN"

        val db = this.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectAll, null)
        }
        catch (e: SQLiteException) {
            db.execSQL(selectAll)
            return ArrayList()
        }

        var id: Int
        var cus: String
        var noMeja: Int
        var produk: String
        var harga: Int
        var jumlah: Int
        var kasir: String



        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID_PESAN))
                cus = cursor.getString(cursor.getColumnIndex(COLUMN_USER))
                noMeja = cursor.getInt(cursor.getColumnIndex(COLUMN_NO_MEJA))
                produk = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUK))
                harga = cursor.getInt(cursor.getColumnIndex(COLUM_HARGA_PRODUK))
                jumlah = cursor.getInt(cursor.getColumnIndex(COLUMN_JUMLAH))
                kasir = cursor.getString(cursor.getColumnIndex(COLUMN_KASIR))

                val pemesananList = Pemesanan(
                    id = id, cus = cus, noMeja = noMeja, produk = produk, harga = harga,
                        jumlah = jumlah, kasir = kasir)
                pesanList.add(pemesananList)
            } while (cursor.moveToNext())
        }

        return pesanList
    }

    fun updatePemesan(dataPesan: Pemesanan): Int {
        val db = this.writableDatabase
        val data = ContentValues()
        data.put(COLUMN_USER, dataPesan.cus)
        data.put(COLUMN_NO_MEJA, dataPesan.noMeja)
        data.put(COLUMN_PRODUK, dataPesan.produk)
        data.put(COLUM_HARGA_PRODUK, dataPesan.harga)
        data.put(COLUMN_JUMLAH, dataPesan.jumlah)

        val update =  db.update(TABLE_PEMESANAN, data, COLUMN_ID_PESAN + "=" + dataPesan.id, null)
        return update
    }

    fun deletePemesanan(dataPesan: Pemesanan): Int {
        val db = this.writableDatabase
        val data = ContentValues()
        data.put(COLUMN_ID_PESAN, dataPesan.id)
        Log.e("TAG", "delete " + dataPesan.id)

        val delete = db.delete(TABLE_PEMESANAN, COLUMN_ID_PESAN + " = " + dataPesan.id, null)
        Log.e("TAG", "delete $delete")

        db.close()
        return delete
    }

    companion object{
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "FinalProjectBochilCoffee"
        val TABLE_PEMESANAN = "pemesanan"
        val COLUMN_ID_PESAN = "id"
        val COLUMN_USER = "user"
        val COLUMN_NO_MEJA = "no_meja"
        val COLUMN_PRODUK = "produk"
        val COLUM_HARGA_PRODUK = "harga_produk"
        val COLUMN_JUMLAH = "jumlah"
        val COLUMN_KASIR = "kasir"

    }

}

