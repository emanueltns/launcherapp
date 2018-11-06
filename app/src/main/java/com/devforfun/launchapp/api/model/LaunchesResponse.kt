package com.devforfun.launchapp.api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class LaunchesResponse(@SerializedName("launches") val items : List<Launch>,
                            @SerializedName("total") val total : Int,
                            @SerializedName("offset") val offset : Int,
                            @SerializedName("count") val count : Int)
@Parcelize
data class Launch(@SerializedName("id") val id : Int,
                  @SerializedName("name") val name : String,
                  @SerializedName("windowstart") val windowsStart : String,
                  @SerializedName("windowend") val windowed : String,
                  @SerializedName("net") val net : String,
                  @SerializedName("status") val status : Int,
                  @SerializedName("tbdtime") val tbdTime : Int,
                  @SerializedName("vidURLs") val vidUrls : List<String>?,
                  @SerializedName("vidURL") val vidUrl : String?,
                  @SerializedName("tbddate") val tbdDate : Int,
                  @SerializedName("probability") val probability : Int,
                  @SerializedName("hashtag") val hashTag : String?,
                  @SerializedName("changed") val changed : String,
                  @SerializedName("lsp") val lsp : String) : Parcelable