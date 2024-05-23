package com.haohao.rememberearn.presentation.ui.states

data class UiState(
    var progressState: ProgressState = ProgressState.NoLoading,
    var messageState: MessageState = MessageState(),
)

enum class ProgressState {
    Loading,
    NoLoading
}

data class MessageState(
    var msg: String = "",
    var type: MessageType = MessageType.ERROR
)

enum class MessageType {
    ERROR, SUCCESS
}