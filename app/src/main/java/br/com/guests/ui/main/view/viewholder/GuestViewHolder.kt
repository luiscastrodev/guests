package br.com.guests.ui.main.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.guests.R
import br.com.guests.ui.main.model.GuestModel

class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(guestModel: GuestModel){
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.setText(guestModel.name)
    }
}