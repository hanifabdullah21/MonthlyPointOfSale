package com.singpaulee.sandec.monthlypointofsale.rest

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("")
    fun post(
            @Field("search") search:String?
    ) : Observable<ResponseBody>

    /*Method GET for login*/
    @GET("login.php")
    fun login(
            @Query("username") username:String,
            @Query("password") password:String
    ) : Observable<ResponseBody>
}