package com.enuygun.casestudy.model.dataModels

import com.google.gson.annotations.SerializedName


data class Flights (

  @SerializedName("departure" ) var departure : ArrayList<Departure> = arrayListOf()

)