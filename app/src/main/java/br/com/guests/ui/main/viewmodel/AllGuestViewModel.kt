package br.com.guests.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.guests.ui.main.model.GuestModel
import br.com.guests.ui.main.service.GuestRepository

    class AllGuestViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository  = GuestRepository.getInstance(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()

    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(){
        mGuestList.value = mGuestRepository.getAll()
    }
}