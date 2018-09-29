package com.singpaulee.sandec.monthlypointofsale.newitem.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.singpaulee.sandec.monthlypointofsale.R
import com.singpaulee.sandec.monthlypointofsale.helpers.HelperView
import com.singpaulee.sandec.monthlypointofsale.newitem.fragment.FormAddItemFragment
import com.singpaulee.sandec.monthlypointofsale.newitem.fragment.ScanCodeFragment

class AddNewItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_item)

        if (intent != null) {
            val halaman = intent.getIntExtra(HelperView.Gift.VIEW, 0)
            setViewFragment(halaman)
        }
    }

    private fun setViewFragment(halaman: Int) {
        when (halaman) {
            HelperView.View.SCANADDITEM -> {
                setFragment(ScanCodeFragment())
            }
            HelperView.View.FORMADDITEM -> {
                //Set data yang akan dipasrsing
                var idItem = intent.getStringExtra(HelperView.Gift.IDITEM)
                var bundle = Bundle()
                bundle.putString(HelperView.Gift.IDITEM, idItem)
                //Set Fragment
                var fragment = FormAddItemFragment()
                fragment.arguments = bundle
                setFragment(fragment)
            }
        }
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
