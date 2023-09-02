package com.ezriouil.freetoplay.presentation.view_model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezriouil.freetoplay.data.repository.GameRepositoryImpl
import com.ezriouil.freetoplay.domain.model.GameDetail
import com.ezriouil.freetoplay.utils.GAME_ID
import com.ezriouil.freetoplay.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    repository: GameRepositoryImpl,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var gameId: Int = 0

    private val _game: MutableStateFlow<Resource<GameDetail>> = MutableStateFlow(Resource.Loading)
    val game: StateFlow<Resource<GameDetail>> = _game

    init {
        savedStateHandle.get<String>(GAME_ID)?.let {
            gameId = it.toInt()
        }
        viewModelScope.launch {
            _game.update { repository.getGame(gameId) }
        }
    }

}