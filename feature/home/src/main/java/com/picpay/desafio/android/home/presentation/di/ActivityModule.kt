package com.picpay.desafio.android.home.presentation.di

import com.picpay.desafio.android.home.presentation.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity
}