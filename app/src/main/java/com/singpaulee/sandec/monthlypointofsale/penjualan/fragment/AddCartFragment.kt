package com.singpaulee.sandec.monthlypointofsale.penjualan.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.zxing.Result

import com.singpaulee.sandec.monthlypointofsale.R
import kotlinx.android.synthetic.main.fragment_add_cart.*
import me.dm7.barcodescanner.zxing.ZXingScannerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
//TODO 3 Setting Scanner
class AddCartFragment : Fragment(), ZXingScannerView.ResultHandler {

    lateinit var itemView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        itemView = inflater.inflate(R.layout.fragment_add_cart, container, false)
        return itemView
    }

    override fun handleResult(result: Result?) {
        //TODO 4 Setting handler if scan success
        Log.d("ACF",result?.text.toString())
        Log.d("ACF",result?.barcodeFormat.toString())

        //Open Dialog
    }

    override fun onResume() {
        super.onResume()
        sv_scanner.setResultHandler(this)
        sv_scanner.startCamera()
        sv_scanner.setAutoFocus(true)
        sv_scanner.flash = true
    }

    override fun onPause() {
        super.onPause()
        sv_scanner.stopCamera()
    }
}
