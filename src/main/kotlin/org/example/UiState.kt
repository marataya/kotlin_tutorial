package org.example


fun render(state: UiState) = when (state) {
    is UiState.Loading -> println("Loading")
    is UiState.Loaded -> println("Loaded: ${state.title}")
    is UiState.Error -> println("Error")
}

fun initSealedState() {
    var state : UiState = UiState.Loading
    render(state)
    state = UiState.Loaded("Kotlin", "ahaha")
    render(state)
    state = UiState.Error(IllegalStateException())
}
sealed class UiState {
    object Loading : UiState()
    data class Loaded(val title: String, val subtitle: String) : UiState()

    class Error(val error: Throwable) : UiState()
}
