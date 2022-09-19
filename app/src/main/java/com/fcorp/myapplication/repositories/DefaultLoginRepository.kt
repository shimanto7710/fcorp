/*
 * Copyright (c) 2021 by Brac-UPG Programme
 * All Rights Reserved by BRAC
 * Powered By BMQA
 * BMQA-BRAC Confidential
 */

package com.fcorp.myapplication.repositories

import com.fcorp.myapplication.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class DefaultLoginRepository @Inject constructor(
    private val apiService: ApiService
) : LoginRepository {

    override suspend fun makeLoginRequest(loginRequest: String): Response<String> {
        return apiService.login(loginRequest)
    }


}