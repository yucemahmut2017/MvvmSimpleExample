package com.enuygun.casestudy.model.enuygun

import com.google.gson.annotations.SerializedName


data class Flights (

  @SerializedName("departure" ) var departure : ArrayList<Departure> = arrayListOf()

)