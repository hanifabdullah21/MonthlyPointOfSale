package com.singpaulee.sandec.monthlypointofsale.newitem.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.zxing.Result

import com.singpaulee.sandec.monthlypointofsale.R
import me.dm7.barcodescanner.zxing.ZXingScannerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ScanCodeFragment : Fragment(), ZXingScannerView.ResultHandler {

    lateinit var itemView:View
    var idItem = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        itemView = inflater.inflate(R.layout.fragment_scan_code, container, false)

        //TODO Button Click
        //TODO Validasi

        return itemView
    }

    //TODO Scan Code
    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()

    }

    //TODO Handle Result Scan
    override fun handleResult(p0: Result?) {
        //TODO Set Result to Edittext and then go to form item

    }

    //TODO Go to form item, passing "idItem"
    fun goToNext(){

    }


    fun validasi():Boolean{
        return false
    }
}
