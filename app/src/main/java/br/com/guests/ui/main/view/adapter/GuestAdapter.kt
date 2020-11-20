package br.com.guests.ui.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.guests.R
import br.com.guests.ui.main.model.GuestModel
import br.com.guests.ui.main.view.viewholder.GuestViewHolder

class GuestAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    private var mGuestList : List<GuestModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest, parent, false)
        return GuestViewHolder(item)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {

        holder.bind(mGuestList[position])
    }

    override fun getItemCount(): Int {
        return mGuestList.count()
    }


    fun updateGuest(list: List<GuestModel>){
        mGuestList = list
        notifyDataSetChanged()
    }
}