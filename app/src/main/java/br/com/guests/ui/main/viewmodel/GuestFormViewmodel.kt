package br.com.guests.ui.main.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.guests.ui.main.model.GuestModel
import br.com.guests.ui.main.service.GuestRepository

class GuestFormViewmodel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext

    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    fun save(name: String, presence: Boolean) {
        val newGuest = GuestModel(name, presence)
        mGuestRepository.save(newGuest)
    }
}