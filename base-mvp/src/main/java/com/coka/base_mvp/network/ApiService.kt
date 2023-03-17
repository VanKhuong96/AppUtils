package com.coka.base_mvp.network

import com.coka.base_mvp.models.MemberResponse

interface ApiService {

    suspend fun fetchMemberInfo():MemberResponse
}