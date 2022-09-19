/*
 * Copyright (c) 2021 by Brac-UPG Programme
 * All Rights Reserved by BRAC
 * Powered By BMQA
 * BMQA-BRAC Confidential
 */

package com.fcorp.myapplication

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
public class Application : Application(){
    companion object {
        private lateinit var instance: Application
        public fun getContext(): Context {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this;
    }
}