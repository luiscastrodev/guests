package br.com.guests.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.guests.ui.main.model.GuestModel
import br.com.guests.ui.main.service.GuestRepository
import br.com.guests.ui.main.service.constants.GuestConstants

class GuestViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()

    val guestList: LiveData<List<GuestModel>> = mGuestList


    fun load(filter: Int) {

        when (filter) {
            GuestConstants.FILTER.EMPTY -> {
                mGuestList.value = mGuestRepository.getAll()
            }
            GuestConstants.FILTER.ABSENT -> {
                mGuestList.value = mGuestRepository.getAbsent()
            }
            GuestConstants.FILTER.PRESENT -> {
                mGuestList.value = mGuestRepository.getPresent()
            }
        }

    }

    fun delete(id: Int) {
        mGuestRepository.delete(id)
    }
}