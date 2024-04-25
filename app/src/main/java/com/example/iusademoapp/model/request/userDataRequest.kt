package com.example.iusademoapp.model.request

import com.google.gson.annotations.SerializedName

data class userDataRequest(@SerializedName("name") var fullName: String = "", var phone: String = "", var mail: String = "")
