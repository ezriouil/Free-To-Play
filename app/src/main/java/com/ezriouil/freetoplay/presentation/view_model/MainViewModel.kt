package com.ezriouil.freetoplay.presentation.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezriouil.freetoplay.data.repository.GameRepositoryImpl
import com.ezriouil.freetoplay.domain.model.Game
import com.ezriouil.freetoplay.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val gameRepository: GameRepositoryImpl) :
    ViewModel() {

    private val _splashScreenVisible = mutableStateOf(value = false)
    val splashScreenVisible: State<Boolean> = _splashScreenVisible

    private val _games = MutableStateFlow<Resource<List<Game>>>(Resource.Loading)
    val games: StateFlow<Resource<List<Game>>> = _games

    init {
        viewModelScope.launch {
            //_splashScreenVisible.value = true
            delay(2000)
            _games.update { gameRepository.getAllGames() }
            //_splashScreenVisible.value = false
        }
    }
}