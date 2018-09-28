package com.singpaulee.sandec.monthlypointofsale.penjualan.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.singpaulee.sandec.monthlypointofsale.R
import com.singpaulee.sandec.monthlypointofsale.helpers.HelperView
import com.singpaulee.sandec.monthlypointofsale.penjualan.fragment.AddCartFragment

class PenjualanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penjualan)

        var gift = intent.getIntExtra(HelperView.Gift.VIEW, 0)
        if (gift != 0){
            setViewFragment(gift)
        }
    }

    private fun setViewFragment(view: Int) {
        when(view){
            HelperView.View.ADDITEM -> {
                setFragment(AddCartFragment())
            }
        }
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
