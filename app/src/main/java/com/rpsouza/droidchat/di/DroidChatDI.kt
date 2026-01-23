package com.rpsouza.droidchat.di

import com.rpsouza.droidchat.ui.feature.signin.SignInViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val viewModelModule = module {
    viewModel { SignInViewModel() }
}

val appModules = module {
    includes(viewModelModule)
}