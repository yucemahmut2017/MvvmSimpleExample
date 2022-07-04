package com.enuygun.casestudy.model.enuygun

import com.google.gson.annotations.SerializedName


data class PriceHistory (

  @SerializedName("departure" ) var departure : Departure? = Departure()

)