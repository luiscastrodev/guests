package br.com.guests.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import br.com.guests.R
import br.com.guests.ui.main.viewmodel.GuestFormViewmodel
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var viewmodel: GuestFormViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        viewmodel = ViewModelProvider(this).get(GuestFormViewmodel::class.java)

        setListeners()
    }

    private fun setListeners() {
        button_save.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.button_save) {

        }
    }
}