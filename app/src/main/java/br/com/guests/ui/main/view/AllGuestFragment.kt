package br.com.guests.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.guests.R
import br.com.guests.ui.main.view.adapter.GuestAdapter
import br.com.guests.ui.main.viewmodel.AllGuestViewModel

class AllGuestFragment : Fragment() {

    private lateinit var allGuestViewModel: AllGuestViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        allGuestViewModel =
            ViewModelProvider(this).get(AllGuestViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all_guests, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

        recycler.layoutManager = LinearLayoutManager(context)

        recycler.adapter = mAdapter

        observer()

        return root
    }

    override fun onResume() {
        super.onResume()

        allGuestViewModel.load()
    }

    private fun observer(){
        allGuestViewModel.guestList.observe(viewLifecycleOwner, Observer{
            mAdapter.updateGuest(it)
        })
    }
}