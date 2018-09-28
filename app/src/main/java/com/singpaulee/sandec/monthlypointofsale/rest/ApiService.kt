package com.singpaulee.sandec.monthlypointofsale.rest

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("")
    fun post(
            @Field("search") search:String?
    ) : Observable<ResponseBody>
}