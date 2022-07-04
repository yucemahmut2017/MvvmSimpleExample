package com.enuygun.casestudy.model.dataModels

import com.google.gson.annotations.SerializedName


data class BaggageInfo (

  @SerializedName("carryOn"                ) var carryOn                : CarryOn?                          = CarryOn(),
  @SerializedName("firstBaggageCollection" ) var firstBaggageCollection : ArrayList<FirstBaggageCollection> = arrayListOf()

)