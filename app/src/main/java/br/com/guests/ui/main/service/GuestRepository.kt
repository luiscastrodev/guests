package br.com.guests.ui.main.service

import br.com.guests.ui.main.model.GuestModel

class GuestRepository {

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

    }

    fun update(guestModel: GuestModel) {

    }

    fun delete(guestModel: GuestModel) {

    }
}