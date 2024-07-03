package com.haohao.rememberearn.presentation.compose.home

import androidx.lifecycle.viewModelScope
import com.haohao.rememberearn.presentation.compose.home.HomeState
import com.haohao.rememberearn.presentation.viewmodels.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : BaseViewModel() {
    val candleState: StateFlow<HomeState> = flowOf(HomeState.Loading)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeState.Loading,
        )

    fun calcData(){

    }
}