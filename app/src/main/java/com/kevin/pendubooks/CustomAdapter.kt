package com.kevin.pendubooks

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.kevin.pendubooks.model.UserModel
import java.util.*

class CustomAdapter(
    private val context: Context,
    private val userModelArrayList: ArrayList<UserModel>
) :
    BaseAdapter() {


    override fun getCount(): Int {
        return userModelArrayList.size
    }

    override fun getItem(position: Int): Any {
        return userModelArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder

        if (convertView == null) {
            holder = ViewHolder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.lv_item, null, true)

            holder.tvnamakantin = convertView!!.findViewById(R.id.namaKantin) as TextView
            holder.tvnama = convertView.findViewById(R.id.nama) as TextView
            holder.tvjumlahanak = convertView.findViewById(R.id.jumlahAnak) as TextView
            holder.tvalamat = convertView.findViewById(R.id.alamat) as TextView
            holder.tvgaji = convertView.findViewById(R.id.gaji) as TextView
            convertView.tag = holder
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = convertView.tag as ViewHolder
        }

        holder.tvnamakantin!!.text = "Nama Kantin     : " + userModelArrayList[position].getNamaKantins()
        holder.tvnama!!.text = "Nama                  : " + userModelArrayList[position].getNamas()
        holder.tvjumlahanak!!.text = "Jumlah Anak     : " + userModelArrayList[position].getJumlahAnaks()
        holder.tvalamat!!.text = "Alamat                : " + userModelArrayList[position].getAlamats()
        holder.tvgaji!!.text = "Kebutuhan (Rp) : " + userModelArrayList[position].getGajis()


        return convertView
    }

    private inner class ViewHolder {

        var tvnamakantin: TextView? = null
        var tvnama: TextView? = null
        var tvjumlahanak: TextView? = null
        var tvalamat: TextView? = null
        var tvgaji: TextView? = null
    }

}