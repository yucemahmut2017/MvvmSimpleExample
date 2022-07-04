package com.enuygun.casestudy
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.enuygun.casestudy.model.MyDataService
import com.enuygun.casestudy.model.dataModels.DataModel
import com.enuygun.casestudy.viewmodel.MainViewModel
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class MainViewModelTest {


    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Mock
    lateinit var myDataService: MyDataService

    @InjectMocks
    var listViewModel = MainViewModel()


    private var testSingle: Single<DataModel>? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun getAllDataSuccess() {
        val dataModel=DataModel()


        testSingle = Single.just(dataModel)
        `when`(myDataService.getAllData()).thenReturn(testSingle)

        listViewModel.refresh()

        Assert.assertEquals(1, listViewModel.myDataService.getAllData())

        Assert.assertEquals(false, listViewModel.datLoadError.value)

        Assert.assertEquals(false, listViewModel.loading.value)

    }

    @Test
    fun getAllDataFail() {

        testSingle = Single.error(Throwable())

        `when`(myDataService.getAllData()).thenReturn(testSingle)

        listViewModel.refresh()

        Assert.assertEquals(true, listViewModel.datLoadError.value)

        Assert.assertEquals(false, listViewModel.loading.value)

    }



}