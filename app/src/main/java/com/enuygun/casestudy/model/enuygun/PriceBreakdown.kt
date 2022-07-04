package com.enuygun.casestudy.model.enuygun

import com.google.gson.annotations.SerializedName
import java.util.*


data class PriceBreakdown (

  @SerializedName("base"               ) var base              : Double?    = null,
  @SerializedName("tax"                ) var tax               : Double?    = null,
  @SerializedName("service"            ) var service           : Double? = null,
  @SerializedName("reissue_service"    ) var reissueService    : Double?    = null,
  @SerializedName("total"              ) var total             : Double? = null,
  @SerializedName("currency"           ) var currency          : String? = null,
  @SerializedName("discount"           ) var discount          : Double?    = null,
  @SerializedName("displayed_currency" ) var displayedCurrency : String? = null,
  @SerializedName("internal_assurance" ) var internalAssurance : Double?    = null,
  @SerializedName("extra_fee"          ) var extraFee          : Double?    = null,
  @SerializedName("penalty"            ) var penalty           : Double?    = null

)