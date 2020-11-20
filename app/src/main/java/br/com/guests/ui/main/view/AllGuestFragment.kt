package br.com.guests.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.guests.R
import br.com.guests.ui.main.viewmodel.AllGuestViewModel

class AllGuestFragment : Fragment() {

    private lateinit var allGuestViewModel: AllGuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allGuestViewModel =
            ViewModelProvider(this).get(AllGuestViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_all_guests, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        allGuestViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val btn: TextView = root.findViewById(R.id.btn_all_guests)
        btn.setOnClickListener {
            allGuestViewModel.setValue("Change the name")
        }

        return root
    }
}