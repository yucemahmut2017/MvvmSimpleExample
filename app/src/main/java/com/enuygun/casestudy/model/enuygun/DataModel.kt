package com.enuygun.casestudy.model.enuygun

import com.google.gson.annotations.SerializedName


data class DataModel (

  @SerializedName("data" ) var data : Data? = Data()

)