package com.enuygun.casestudy.model.dataModels

import com.google.gson.annotations.SerializedName


data class AveragePriceBreakdown (

  @SerializedName("base"               ) var base              : Double?    = null,
  @SerializedName("tax"                ) var tax               : Double?    = null,
  @SerializedName("service"            ) var service           : Double? = null,
  @SerializedName("reissue_service"    ) var reissueService    : Int?    = null,
  @SerializedName("total"              ) var total             : Double? = null,
  @SerializedName("currency"           ) var currency          : String? = null,
  @SerializedName("discount"           ) var discount          : Int?    = null,
  @SerializedName("displayed_currency" ) var displayedCurrency : String? = null,
  @SerializedName("internal_assurance" ) var internalAssurance : Int?    = null,
  @SerializedName("extra_fee"          ) var extraFee          : Int?    = null,
  @SerializedName("penalty"            ) var penalty           : Int?    = null

)