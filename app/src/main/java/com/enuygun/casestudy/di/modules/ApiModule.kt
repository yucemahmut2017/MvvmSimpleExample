package com.enuygun.casestudy.di.modules

import dagger.Module
import dagger.Provides
import com.enuygun.casestudy.model.GetAllDataApi
import com.enuygun.casestudy.model.MyDataService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val BASE_URL = "https://raw.githubusercontent.com"


    /***
     *
     * ihtiyacımız olan sınıfları bu annotationla belirtiypruz.dagger 2 ihtiyacımız olduğunda bize bu sınıfları üretecektir.
     */
    @Provides
    fun provideCountriesApi(): GetAllDataApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//ben RxJavayı kullanacam
            .build()
            .create(GetAllDataApi::class.java)
    }

    @Provides
    fun provideCountriesService(): MyDataService {
        return MyDataService()
    }

}