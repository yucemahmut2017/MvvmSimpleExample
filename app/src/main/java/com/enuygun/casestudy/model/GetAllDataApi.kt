package com.enuygun.casestudy.model

import com.enuygun.casestudy.model.enuygun.DataModel
import io.reactivex.Single
import retrofit2.http.GET

interface GetAllDataApi {

    @GET("yucemahmut2017/EnUygun/main/enuygun_flight_search.json")
    fun getData(): Single<DataModel>
}