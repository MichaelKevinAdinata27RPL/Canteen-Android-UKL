package com.kevin.pendubooks

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.kevin.pendubooks.db.DatabaseHelper
import com.kevin.pendubooks.model.UserModel
import kotlinx.android.synthetic.main.fragment_list.view.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {
    lateinit var con: Context
    private var listView: ListView? = null
    private var userModelArrayList: ArrayList<UserModel>? = null
    private var customAdapter: CustomAdapter? = null
    private var databaseHelper: DatabaseHelper? = null
    private var btnGetall: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val x = inflater.inflate(R.layout.fragment_list, container, false)

        x.btnget.setOnClickListener{
            fecthData()
        }

        listView = x.lv_item

        return x
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        databaseHelper = DatabaseHelper(context)
        con = context

    }

    fun fecthData(){
        userModelArrayList = databaseHelper!!.getAllUsers
        customAdapter = CustomAdapter(con, this!!.userModelArrayList!!)
        listView!!.adapter = customAdapter
    }

    companion object {
        fun newInstance(): ListFragment {
            val fragment = ListFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}
