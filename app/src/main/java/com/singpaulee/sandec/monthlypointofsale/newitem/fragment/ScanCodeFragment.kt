package com.singpaulee.sandec.monthlypointofsale.newitem.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.zxing.Result
import com.singpaulee.sandec.monthlypointofsale.R
import com.singpaulee.sandec.monthlypointofsale.helpers.HelperView
import com.singpaulee.sandec.monthlypointofsale.newitem.activity.AddNewItemActivity
import kotlinx.android.synthetic.main.fragment_scan_code.view.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import org.jetbrains.anko.sdk25.coroutines.onClick

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
        itemView.btn_next.onClick {
            //TODO Validasi
            if (!validasi()){
                return@onClick
            }

            goToNext()
        }

        return itemView
    }

    //TODO Scan Code
    override fun onResume() {
        super.onResume()
        itemView.sv_scanner_scf.setResultHandler(this)
        itemView.sv_scanner_scf.startCamera()
        itemView.sv_scanner_scf.setAutoFocus(true)
        itemView.sv_scanner_scf.flash = true
    }

    override fun onPause() {
        super.onPause()
        itemView.sv_scanner_scf.stopCamera()
    }

    //TODO Handle Result Scan
    override fun handleResult(result: Result?) {
        //TODO Set Result to Edittext and then go to form item
        idItem = result?.text.toString()
        goToNext()
    }

    //TODO Go to form item, passing "idItem"
    fun goToNext(){
        var intent = Intent(activity, AddNewItemActivity::class.java)
        intent.putExtra(HelperView.Gift.IDITEM, idItem)
        startActivity(intent)
    }


    fun validasi():Boolean{
        if (itemView.edt_kode.text.toString().isBlank()){
            itemView.edt_kode.error = "Tidak Boleh Kosong"
        }
        return false
    }
}
