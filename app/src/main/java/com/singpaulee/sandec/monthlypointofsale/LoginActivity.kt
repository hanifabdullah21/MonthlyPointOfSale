package com.singpaulee.sandec.monthlypointofsale

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.singpaulee.sandec.monthlypointofsale.models.UserModel
import com.singpaulee.sandec.monthlypointofsale.rest.ApiService
import com.singpaulee.sandec.monthlypointofsale.rest.ConfigRetrofit
import com.singpaulee.sandec.monthlypointofsale.sharedpreference.SharedPrefManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.ResponseBody
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast
import org.json.JSONObject
import java.util.*

class LoginActivity : AppCompatActivity() {

    lateinit var session: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        session = SharedPrefManager(this)

        //TODO Cek sudah login apa belum
        if(session.getSudahLogin()){
            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            finish()
        }

        val animation = line_login.background as AnimationDrawable
        animation.setEnterFadeDuration(2000)
        animation.setExitFadeDuration(4000)
        animation.start()

        //TODO Handler ketika butto n login diklik
        card_masuk.onClick {
            //TODO Validasi Form
            if (!validasi()) {
                return@onClick
            }

            requestLogin()
        }

    }

    /*Method untuk request login ke serber*/
    private fun requestLogin() {
        val login = ConfigRetrofit.retrofits
                .create<ApiService>(ApiService::class.java)
                .login(edt_username.text.toString(),
                        edt_password.text.toString())

        login.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    val json = response.string()
                    val JSONOBJECT = JSONObject(json)
                    val e = JSONOBJECT.optBoolean("error")
                    if (!e) {
                        val result = JSONObject(json).getJSONObject("users")
                        var users = Gson().fromJson(result.toString(), UserModel::class.java)

                        //TODO Save to sharedpreferences
                        session.savePrefString(session.NAMA,users.nama)
                        session.savePrefString(session.ID,users.id)
                        session.savePrefString(session.USERNAME,users.username)
                        session.savePrefBoolean(session.SUDAHLOGIN,true)

                        //TODO Intent to MainActivity
                        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                        finish()
                    }else{
                        toast("Username/Password Salah")
                    }
                },{error ->
                    toast(error.localizedMessage)
                })


    }

    /*Method untuk validasi edittext*/
    private fun validasi(): Boolean {
        if (edt_username.text.toString().isBlank()) {
            edt_username.error = "Tidak boleh kosong"
            edt_username.requestFocus()
            return false
        }
        if (edt_password.text.toString().isBlank()) {
            edt_password.error = "Tidak boleh kosong"
            edt_password.requestFocus()
            return false
        }
        return true
    }


}
