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

    fun save(id: Int, name: String, presence: Boolean) {
        val newGuest = GuestModel(id, name, presence)

        if (id == 0) {
            mSaveGuest.value = mGuestRepository.save(newGuest)
        } else {
            mSaveGuest.value = mGuestRepository.update(newGuest)
        }
    }

    private var mGuest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = mGuest

    fun loadUser(id: Int) {
        mGuest.value = mGuestRepository.get(id)
    }
}