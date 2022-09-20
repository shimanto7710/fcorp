package com.fcorp.myapplication

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.fcorp.myapplication.databinding.ActivityMainBinding
import com.fcorp.myapplication.ui.SplashScreenFragment
import com.fcorp.myapplication.utils.getCanonicalName

class MainActivity : AppCompatActivity() {
    lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        loadHomeFragment()
    }

    private fun loadHomeFragment(){
        supportFragmentManager.commit {
            val homeFragment = SplashScreenFragment.newInstance()
            replace(R.id.mainFragmentContainer, homeFragment, getCanonicalName(homeFragment))
            setReorderingAllowed(true)
            addToBackStack(getCanonicalName(homeFragment))
        }
    }
}