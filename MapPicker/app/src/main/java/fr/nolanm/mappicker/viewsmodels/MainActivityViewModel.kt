package fr.nolanm.mappicker.viewsmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.nolanm.mappicker.R

class MainActivityViewModel : ViewModel() {
    val mainBackgroundId = R.drawable.main_background

    private val _home = MutableLiveData("")
    val home: LiveData<String> = _home

    private val _away = MutableLiveData("")
    val away: LiveData<String> = _away

    fun onHomeChange(newHome: String) { _home.value = newHome }
    fun onAwayChange(newAway: String) { _away.value = newAway }

    fun onButtonClick() {
        Log.v("EQUIPE", "Home ${home.value} / Away : ${away.value}")

    }
}