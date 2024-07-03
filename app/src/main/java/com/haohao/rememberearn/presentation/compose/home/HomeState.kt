package com.haohao.rememberearn.presentation.compose.home

sealed interface HomeState {
    data object Loading : HomeState
    data class Success(val a: Boolean = false) : HomeState
}
