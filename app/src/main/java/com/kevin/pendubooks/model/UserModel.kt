package com.kevin.pendubooks.model

import java.io.Serializable

class UserModel : Serializable {
    var id: Int = 0
    var namaKantin: String? = null
    var nama: String? = null
    var jumlahAnak: String? = null
    var alamat: String? = null
    var gajiPerBulan: String? = null

    fun getIds(): Int {
        return id
    }

    fun setIds(id: Int) {
        this.id = id
    }

    fun getNamaKantins(): String {
        return namaKantin.toString()
    }

    fun setNamaKantins(namakantin: String) {
        this.namaKantin = namakantin
    }

    fun getNamas(): String {
        return nama.toString()
    }

    fun setNamas(nama: String) {
        this.nama = nama
    }

    fun getJumlahAnaks(): String {
        return jumlahAnak.toString()
    }

    fun setJumlahAnaks(jumlahanak: String) {
        this.jumlahAnak = jumlahanak
    }

    fun getAlamats(): String {
        return alamat.toString()
    }

    fun setAlamats(alamat: String) {
        this.alamat = alamat
    }

    fun getGajis(): String {
        return gajiPerBulan.toString()
    }

    fun setGajis(gaji: String) {
        this.gajiPerBulan= gaji
    }


}