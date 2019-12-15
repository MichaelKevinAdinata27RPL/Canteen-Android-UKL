package com.kevin.pendubooks


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kevin.pendubooks.db.DatabaseHelper
import kotlinx.android.synthetic.main.fragment_tambah.view.*

/**
 * A simple [Fragment] subclass.
 */
class TambahFragment : Fragment() {

    private var btnStore: Button? = null
    private var btnGetall: Button? = null
    private var namakantin: EditText? = null
    private var nama: EditText? = null
    private var jumlahanak: EditText? = null
    private var alamat: EditText? = null
    private var gaji: EditText? = null
    private var databaseHelper: DatabaseHelper? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val x = inflater.inflate(R.layout.fragment_tambah, container, false)

        btnStore = x.btnSave
        namakantin = x.edt_text_nama_kantin
        nama = x.edt_text_nama
        jumlahanak = x.edt_text_jumlah_anak
        alamat = x.edt_text_alamat
        gaji = x.edt_text_gaji


        btnStore!!.setOnClickListener {
            databaseHelper!!.addUserDetail(
                namakantin!!.text.toString(),
                nama!!.text.toString(),
                jumlahanak!!.text.toString(),
                alamat!!.text.toString(),
                gaji!!.text.toString()
            )
            namakantin!!.setText("")
            nama!!.setText("")
            jumlahanak!!.setText("")
            alamat!!.setText("")
            gaji!!.setText("")
            Toast.makeText(context, "Successfully!", Toast.LENGTH_SHORT).show()
        }

        return x

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        databaseHelper = DatabaseHelper(context)
    }

    companion object {
        fun newInstance(): TambahFragment {
            val fragment = TambahFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }


}
