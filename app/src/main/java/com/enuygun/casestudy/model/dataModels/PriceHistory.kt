package com.enuygun.casestudy.model.dataModels

import com.google.gson.annotations.SerializedName


data class PriceHistory (

  @SerializedName("departure" ) var departure : Departure? = Departure()

)