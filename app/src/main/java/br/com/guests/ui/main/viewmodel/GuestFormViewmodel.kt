package br.com.guests.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.guests.ui.main.model.GuestModel
import br.com.guests.ui.main.service.GuestRepository

class GuestFormViewmodel : ViewModel() {
    private val mGuestRepository: GuestRepository = GuestRepository()

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    fun save(name: String, presence: Boolean) {
        val newguest = GuestModel(name, presence)
        mGuestRepository.save(newguest)
    }
}