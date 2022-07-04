package com.enuygun.casestudy.model.enuygun

import com.google.gson.annotations.SerializedName


data class ReturnPrice (

  @SerializedName("min" ) var min : Int? = null,
  @SerializedName("max" ) var max : Int? = null

)