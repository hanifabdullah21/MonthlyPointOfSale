package com.singpaulee.sandec.monthlypointofsale.newitem.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.singpaulee.sandec.monthlypointofsale.R
import kotlinx.android.synthetic.main.layout_btn_bottom.*
import kotlinx.android.synthetic.main.layout_btn_bottom.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FormAddItemFragment : Fragment() {

    lateinit var itemView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        itemView = inflater.inflate(R.layout.fragment_form_add_item, container, false)

        itemView.tv_btnbottom.text = "Tambah item"

        //TODO Handler Button Click
        cv_btnbottom.onClick {
            //TODO Validasi Form
            if (validasi()){
                return@onClick
            }

            //TODO Post Item
            postItem()
        }

        return view
    }

    private fun postItem() {
        //TODO Handler When Result Success
        //TODO Handler When Result Failed
    }

    private fun validasi(): Boolean {
        return false
    }


}
