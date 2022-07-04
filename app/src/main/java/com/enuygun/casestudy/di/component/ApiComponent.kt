package com.enuygun.casestudy.di.component

import dagger.Component
import com.enuygun.casestudy.di.modules.ApiModule
import com.enuygun.casestudy.model.MyDataService
import com.enuygun.casestudy.viewmodel.MainViewModel

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: MyDataService)

    fun inject(viewModel: MainViewModel)

}