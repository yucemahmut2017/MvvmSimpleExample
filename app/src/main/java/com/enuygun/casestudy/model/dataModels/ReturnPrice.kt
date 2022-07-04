package com.enuygun.casestudy.model.dataModels

import com.google.gson.annotations.SerializedName


data class ReturnPrice (

  @SerializedName("min" ) var min : Int? = null,
  @SerializedName("max" ) var max : Int? = null

)