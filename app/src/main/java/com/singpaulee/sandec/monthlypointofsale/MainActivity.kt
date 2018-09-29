package com.singpaulee.sandec.monthlypointofsale

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.singpaulee.sandec.monthlypointofsale.helpers.HelperView
import com.singpaulee.sandec.monthlypointofsale.newitem.activity.AddNewItemActivity
import com.singpaulee.sandec.monthlypointofsale.penjualan.activity.PenjualanActivity
import com.singpaulee.sandec.monthlypointofsale.sharedpreference.SharedPrefManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_logout.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_logout.setOnClickListener(this)
        cv_tambahItem.setOnClickListener(this)
        cv_penjualan.setOnClickListener(this)
        cv_stok.setOnClickListener(this)
        cv_penjualan.setOnClickListener(this)
    }

    //TODO Handler OnClick
    override fun onClick(v: View?) {
        when(v){
            tv_logout -> {
                var session = SharedPrefManager(this)
                session.savePrefBoolean(session.SUDAHLOGIN,false)
                finishAffinity()
            }
            cv_tambahItem -> {
                var intent:Intent = Intent(this,AddNewItemActivity::class.java)
                intent.putExtra(HelperView.Gift.VIEW, HelperView.View.SCANADDITEM)
                startActivity(intent)
            }
            cv_penjualan -> {
                var intent:Intent = Intent(this,PenjualanActivity::class.java)
                intent.putExtra(HelperView.Gift.VIEW, HelperView.View.ADDITEM)
                startActivity(intent)
            }
            cv_stok -> {

            }
            cv_rekap -> {

            }
        }
    }
}
