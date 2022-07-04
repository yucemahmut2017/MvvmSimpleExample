package com.enuygun.casestudy.model.dataModels

import com.google.gson.annotations.SerializedName


data class Departure (

  @SerializedName("enuid"                   ) var enuid                 : String?                = null,
  @SerializedName("price_breakdown"         ) var priceBreakdown        : PriceBreakdown?        = PriceBreakdown(),
  @SerializedName("average_price_breakdown" ) var averagePriceBreakdown : AveragePriceBreakdown? = AveragePriceBreakdown(),
  @SerializedName("infos"                   ) var infos                 : Infos?                 = Infos(),
  @SerializedName("provider_packages"       ) var providerPackages      : ArrayList<String>      = arrayListOf(),
  @SerializedName("segments"                ) var segments              : ArrayList<Segments>    = arrayListOf(),
  @SerializedName("different_airline_count" ) var differentAirlineCount : Int?                   = null

)