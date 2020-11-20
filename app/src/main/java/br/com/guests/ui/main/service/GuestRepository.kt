package br.com.guests.ui.main.service

import android.content.Context
import br.com.guests.ui.main.model.GuestModel

class GuestRepository private constructor(context: Context) {

    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {
        private lateinit var respository: GuestRepository

        fun getInstance(context: Context): GuestRepository {

            if (::respository.isInitialized) {
                respository = GuestRepository(context)
            }

            return respository
        }
    }

    fun getAll(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getPresent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAbsent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun save(guestModel: GuestModel) {
        mGuestDataBaseHelper.writableDatabase.execSQL("")
    }

    fun update(guestModel: GuestModel) {

    }

    fun delete(guestModel: GuestModel) {

    }
}