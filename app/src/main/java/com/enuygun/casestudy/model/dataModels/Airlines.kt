package com.enuygun.casestudy.model.dataModels

import com.google.gson.annotations.SerializedName


data class Airlines (

  @SerializedName("code"  ) var code  : String? = null,
  @SerializedName("name"  ) var name  : String? = null,
  @SerializedName("slug"  ) var slug  : String? = null,
  @SerializedName("image" ) var image : String? = null

)