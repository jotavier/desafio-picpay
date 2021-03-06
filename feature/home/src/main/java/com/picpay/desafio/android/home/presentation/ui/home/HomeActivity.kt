package com.picpay.desafio.android.home.presentation.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.ui.setupWithNavController
import com.picpay.desafio.android.base.activity.BaseActivity
import com.picpay.desafio.android.base.extensions.findNavController
import com.picpay.desafio.android.home.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {

    companion object {
        fun newInstance(context: Context) =
            Intent(context, HomeActivity::class.java)
    }

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private val navController by lazy { findNavController(binding.navHostContainer.id) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.toolbar.setupWithNavController(navController)
    }
}