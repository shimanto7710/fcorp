/*
 * Copyright (c) 2021 by Brac-UPG Programme
 * All Rights Reserved by BRAC
 * Powered By BMQA
 * BMQA-BRAC Confidential
 */

package com.fcorp.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fcorp.myapplication.repositories.DefaultLoginRepository
import com.fcorp.myapplication.repositories.LoginRepository
import com.fcorp.myapplication.utils.Resource
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val gson: Gson,
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _loginResponse = MutableLiveData<Resource<String>>()

    val loginResponse : LiveData<Resource<String>>
        get() = _loginResponse


    fun login(email: String, password: String, pin: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if(loginRepository is DefaultLoginRepository) {
                _loginResponse.postValue(Resource.Loading())
            }
            try {
                /*val response = loginRepository.makeLoginRequest(LoginRequest(email, pin, password))
                val result = response.body()
                val errorResult = response.errorBody()
                if (response.isSuccessful && response.code() == 200 && result != null) {
                    _loginResponse.postValue(Resource.Success(result))
                } else if (result!=null && result.status == Constants.KEY_FAILED) {
                    _loginResponse.postValue(Resource.Error(result.status))
                } else {
                    val jObjError = JSONObject(response.errorBody()!!.charStream().readText())
                    val errorMessage= jObjError.get("message")
                    _loginResponse.postValue(Resource.Error(errorMessage.toString()))
                }*/
            } catch (e: Exception) {
                _loginResponse.postValue(Resource.Error(e.message.toString()))
            }
        }
    }
}