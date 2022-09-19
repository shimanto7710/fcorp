/*
 * Copyright (c) 2021 by Brac-UPG Programme
 * All Rights Reserved by BRAC
 * Powered By BMQA
 * BMQA-BRAC Confidential
 */

package com.fcorp.myapplication.repositories

import retrofit2.Response

interface LoginRepository {
    suspend fun makeLoginRequest(loginRequest: String) : Response<String>
}