package com.example.todoapp.androidCookies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class GymsViewModel(
    private val stateHandle: SavedStateHandle
) :ViewModel(){
    var state by mutableStateOf(getSelectedGyms())
   private fun getGyms() = listOfGyms

    fun toggleFavoriteState(gymId:Int){
        val gyms = state.toMutableList()
        val itemIndex = gyms.indexOfFirst { it.id == gymId }
        gyms[itemIndex] = gyms[itemIndex].copy(isFavorite = !gyms[itemIndex].isFavorite)
        storeSelectedGymsFavorite(gyms[itemIndex])
        state = gyms
    }

    private fun storeSelectedGymsFavorite(gym: Gym){
        val savedHandleList = stateHandle.get<List<Int>?>(FAV_IDS).orEmpty().toMutableList()
        if (gym.isFavorite)savedHandleList.add(gym.id) else savedHandleList.remove(gym.id)
        stateHandle[FAV_IDS] = savedHandleList
    }

    private fun getSelectedGyms():List<Gym>{
        val gyms = getGyms()
        stateHandle.get<List<Int>?>(FAV_IDS)?.let { savedIDs ->
            savedIDs.forEach{selectedGymID ->
                gyms.find { it.id == selectedGymID }?.isFavorite = true
            }
        }
        return gyms
    }



    companion object{
        const val FAV_IDS = "favoriteGymsIDs"
    }

}