package com.haohao.rememberearn.presentation.viewmodels.base

import androidx.lifecycle.ViewModel
import com.haohao.rememberearn.presentation.ui.states.MessageState
import com.haohao.rememberearn.presentation.ui.states.ProgressState
import com.haohao.rememberearn.presentation.ui.states.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class BaseViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        UiState(
            progressState = ProgressState.NoLoading,
            messageState = MessageState()
        )
    )
    var uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun updateProgressState(state: ProgressState) {
        _uiState.update { currentState ->
            currentState.copy(progressState = state)
        }
    }

    fun updateMessageState(messageState: MessageState) {
        _uiState.update { currentState ->
            currentState.copy(messageState = messageState)
        }
    }
}
