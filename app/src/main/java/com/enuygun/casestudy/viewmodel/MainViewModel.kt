package com.enuygun.casestudy.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enuygun.casestudy.di.component.DaggerApiComponent
import com.enuygun.casestudy.model.MyDataService
import com.enuygun.casestudy.model.dataModels.DataModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainViewModel : ViewModel() {

    @Inject
    lateinit var myDataService: MyDataService
    private val disposable = CompositeDisposable()


    val data = MutableLiveData<DataModel>()
    val datLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun refresh() {
        fetchFlights()
    }


    private fun fetchFlights() {
        loading.value = true
        disposable.add(
            myDataService.getAllData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<DataModel>() {
                    override fun onSuccess(value: DataModel?) {
                        data.value = value
                        datLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable?) {
                        datLoadError.value = true
                        loading.value = false
                    }

                })
        )
    }


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}