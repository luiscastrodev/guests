package br.com.guests.ui.main.repository

import android.content.Context
import br.com.guests.ui.main.model.GuestModel

class GuestRepository (context: Context) {

    private var mDataBase = GuestDataBase.getDatabase(context).guestDAO()

    fun get(id: Int): GuestModel? {
        return mDataBase.get(id)
    }

    fun getAll(): List<GuestModel> {
        return mDataBase.getInvited()
    }

    fun getPresent(): List<GuestModel> {
        return mDataBase.getPresent()
    }

    fun getAbsent(): List<GuestModel> {
        return mDataBase.getAbsent()
    }

    fun save(guestModel: GuestModel): Boolean {
        return mDataBase.save(guestModel) > 0
    }

    fun update(guestModel: GuestModel): Boolean {
        return mDataBase.update(guestModel) > 0
    }

    fun delete(guest: GuestModel) {
         mDataBase.delete(guest)
    }
}