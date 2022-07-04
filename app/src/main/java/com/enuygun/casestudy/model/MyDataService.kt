package com.enuygun.casestudy.model

import com.enuygun.casestudy.di.component.DaggerApiComponent
import com.enuygun.casestudy.model.dataModels.DataModel
import io.reactivex.Single

import javax.inject.Inject

class MyDataService {

    @Inject
    lateinit var api: GetAllDataApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getAllData(): Single<DataModel> {
        return api.getData()
    }
}