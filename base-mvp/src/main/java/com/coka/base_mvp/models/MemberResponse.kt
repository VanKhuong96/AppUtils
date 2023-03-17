package com.coka.base_mvp.models

import com.google.gson.annotations.SerializedName

data class MemberResponse(
    @field:SerializedName("member_kind")
    var memberKind: Int? = null,
    @JvmField
    @field:SerializedName("cooperation_token")
    var cooperationToken: String? = null,
    @JvmField
    @field:SerializedName("card_number1")
    var cardNumber1: String? = null,
    @JvmField
    @field:SerializedName("card_number2")
    var cardNumber2: String? = null,
    @JvmField
    @field:SerializedName("usable_point")
    var usablePoint: Int? = null,
    @field:SerializedName("point_updated_at")
    var pointUpdatedDate: String? = null,
    @JvmField
    @field:SerializedName("card_balance")
    var balance: Int? = null,
    @JvmField
    @field:SerializedName("error_code")
    var errorCode: String? = null,
    @JvmField
    @field:SerializedName("error_detail")
    var errorDetail: String? = null
) {
    fun  isSuccess():Boolean{
        return  errorCode.isNullOrEmpty()
    }
}