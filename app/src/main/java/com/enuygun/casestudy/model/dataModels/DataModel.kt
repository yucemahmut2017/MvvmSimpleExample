package com.enuygun.casestudy.model.dataModels

import com.google.gson.annotations.SerializedName


data class DataModel (

  @SerializedName("data" ) var data : Data? = Data()

)