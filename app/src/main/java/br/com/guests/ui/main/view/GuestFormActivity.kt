package br.com.guests.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.guests.R
import br.com.guests.ui.main.repository.constants.GuestConstants
import br.com.guests.ui.main.viewmodel.GuestFormViewmodel
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mViewmodel: GuestFormViewmodel
    private var mGuestID: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mViewmodel = ViewModelProvider(this).get(GuestFormViewmodel::class.java)

        setListeners()
        observe()
        loadData()

    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            mGuestID = bundle.getInt(GuestConstants.GUESTID, 0)
            mViewmodel.loadUser(mGuestID)
        }

        mViewmodel.guest.observe(this, Observer {

            edt_name.setText(it.name)

            if (it.presence) {
                radio_presence.isChecked = true
            } else {
                radio_absent.isChecked = true
            }
        })
    }


    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.button_save) {

            val name = edt_name.text.toString()
            val presence = radio_presence.isChecked
            mViewmodel.save(mGuestID,name, presence)

        }
    }

    private fun setListeners() {
        button_save.setOnClickListener(this)
    }

    private fun observe() {
        mViewmodel.saveGuest.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }
        })
    }
}