package br.com.guests.ui.main.view.viewholder

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.guests.R
import br.com.guests.ui.main.model.GuestModel
import br.com.guests.ui.main.view.listener.GuestListener

class GuestViewHolder(itemView: View, private val listener: GuestListener) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(guestModel: GuestModel) {
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guestModel.name

        textName.setOnClickListener {
            listener.onclick(guestModel.id)
        }
        textName.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Delete")
                .setMessage("Do you confirm?")
                .setPositiveButton("YES") { _, _ ->
                    listener.onDelete(guestModel.id)
                }
                .setNegativeButton("NO", null)
                .show()

            true
        }
    }
}