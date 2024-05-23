package com.haohao.rememberearn.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haohao.rememberearn.presentation.ui.states.HomeState
import com.haohao.rememberearn.presentation.viewmodels.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {
    val candleState: StateFlow<HomeState> = flowOf(HomeState())
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = HomeState()
        )

    fun fetchData(){

    }
}