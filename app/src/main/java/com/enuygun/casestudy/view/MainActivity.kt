package com.enuygun.casestudy.view


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.enuygun.casestudy.R
import com.enuygun.casestudy.databinding.ActivityMainBinding
import com.enuygun.casestudy.databinding.CustomTabItemBinding
import com.enuygun.casestudy.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var countriesAdapter: FlightsListAdapter? =
        FlightsListAdapter(arrayListOf(), arrayListOf())


    private  val colorBlack: Int = Color.parseColor("#FF000000")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        instantiateTheViewModel()
        setContentView(view)
    }


    private fun instantiateTheViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.refresh()

        binding.rvFlights.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }

        //set on refresh listener
        binding.swipeRefreshLayout.setOnRefreshListener(this)

        //observe the view model if there are changes
        observeViewModel()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

                val tabBinding = tab.customView?.let {
                    CustomTabItemBinding.bind(it)
                }

                tabBinding?.tabDateText?.setTextColor(ContextCompat.getColor(applicationContext, R.color.purple_200))
                tabBinding?.tabAveragePrice?.setTextColor(ContextCompat.getColor(applicationContext, R.color.purple_200))
                tabBinding?.tabIcon?.visibility=View.VISIBLE


            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabBinding = tab?.customView?.let {
                    CustomTabItemBinding.bind(it)
                }
                tabBinding?.tabDateText?.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
                tabBinding?.tabAveragePrice?.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
                tabBinding?.tabIcon?.visibility=View.GONE


            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })


        binding.tabLayout.getTabAt(1)?.select()


    }


    private fun observeViewModel() {
        viewModel.data.observe(this, Observer { dataModel ->
            dataModel?.let { list ->
                binding.rvFlights.visibility = View.VISIBLE
                countriesAdapter?.updateFlight(list.data?.airlines, list.data?.flights?.departure)
            }
        })

        viewModel.datLoadError.observe(this, Observer { isError ->
            isError?.let { binding.listError.visibility = if (it) View.VISIBLE else View.GONE }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                binding.loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    binding.listError.visibility = View.GONE
                    binding.rvFlights.visibility = View.GONE
                }
            }
        })
    }



    override fun onRefresh() {
        binding.swipeRefreshLayout.isRefreshing = false
        viewModel.refresh()
    }
}
