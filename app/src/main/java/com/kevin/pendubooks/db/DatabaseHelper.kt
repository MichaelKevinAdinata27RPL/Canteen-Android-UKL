package com.kevin.pendubooks.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.kevin.pendubooks.model.UserModel

class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME, null,
    DATABASE_VERSION
) {

    // looping through all rows and adding to list
    // adding to Students list
    val getAllUsers: ArrayList<UserModel>
        get() {
            val userModelArrayList = ArrayList<UserModel>()
            val selectQuery = "SELECT  * FROM $TABLE_USER"
            val db = this.readableDatabase
            val c = db.rawQuery(selectQuery, null)
            if (c.moveToFirst()) {
                do {
                    val userModel = UserModel()
                    userModel.setIds(c.getInt(c.getColumnIndex(KEY_ID)))
                    userModel.setNamaKantins(c.getString(c.getColumnIndex(KEY_NAMAKANTIN)))
                    userModel.setNamas(c.getString(c.getColumnIndex(KEY_NAMA)))
                    userModel.setJumlahAnaks(c.getString(c.getColumnIndex(KEY_JUMLAHANAK)))
                    userModel.setAlamats(c.getString(c.getColumnIndex(KEY_ALAMAT)))
                    userModel.setGajis(c.getString(c.getColumnIndex(KEY_GAJI)))
                    userModelArrayList.add(userModel)
                } while (c.moveToNext())
            }
            return userModelArrayList
        }

    init {
        Log.d("table", CREATE_TABLE_STUDENTS)
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_STUDENTS)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS '$TABLE_USER'")
        onCreate(db)
    }

    fun addUserDetail(
        namakantin: String,
        nama: String,
        jumlahanak: String,
        alamat: String,
        gaji: String
    ): Long {
        val db = this.writableDatabase
        // Creating content values
        val values = ContentValues()
        values.put(KEY_NAMAKANTIN, namakantin)
        values.put(KEY_NAMA, nama)
        values.put(KEY_JUMLAHANAK, jumlahanak)
        values.put(KEY_ALAMAT, alamat)
        values.put(KEY_GAJI, gaji)
        // insert row in students table

        return db.insert(TABLE_USER, null, values)
    }


    companion object {

        var DATABASE_NAME = "user_database"
        private val DATABASE_VERSION = 1
        private val TABLE_USER = "users"
        private val KEY_ID = "id"
        private val KEY_NAMAKANTIN = "namaKantin"
        private val KEY_NAMA = "nama"
        private val KEY_JUMLAHANAK = "jumlahAnak"
        private val KEY_ALAMAT = "alamat"
        private val KEY_GAJI = "gaji"


        /*CREATE TABLE students ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_number TEXT......);*/

        private val CREATE_TABLE_STUDENTS = ("CREATE TABLE "
                + TABLE_USER + "(" + KEY_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAMAKANTIN + " TEXT, " + KEY_NAMA + " TEXT, " + KEY_JUMLAHANAK + " TEXT, "
                + KEY_ALAMAT + " TEXT, " + KEY_GAJI + " TEXT );")
    }

}